package ekwong.question121;

public class Solution {

    public int maxProfit(int[] prices) {
        return maxSum(prices, 0, prices.length - 1);
    }

    private int maxSum(int[] prices, int begin, int end) {
        if (end <= begin) {
            return 0;
        }
        if (end - begin == 1) {
            return Math.max(prices[end] - prices[begin], 0);
        }
        int mid = (end + begin) / 2;
        int maxLeft = maxSum(prices, begin, mid);
        int maxRight = maxSum(prices, mid + 1, end);
        int maxCross = maxCross(prices, begin, end, mid);
        if (maxLeft >= maxRight && maxLeft >= maxCross) {
            return maxLeft;
        }
        if (maxRight >= maxLeft && maxRight >= maxCross) {
            return maxRight;
        }
        return maxCross;
    }

    private int maxCross(int[] prices, int begin, int end, int mid) {
        int buy = 100000;
        for (int i = begin; i <= mid; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
        }
        int sale = -100000;
        for (int i = mid + 1; i <= end; i++) {
            if (prices[i] > sale) {
                sale = prices[i];
            }
        }
        return sale - buy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{2, 1, 2, 0, 1};
        System.out.println(solution.maxProfit(prices));
    }
}
