package ekwong.question9;

public class Solution {

    /**
     * 无需转换成 string 的方案
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = x / (int) Math.pow(10, 10 - 1 - i);
            if (nums[i] != 0) {
                x %= (int) Math.pow(10, 10 - 1 - i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i, k = nums.length - 1; j < k; j++, k--) {
                    if (nums[j] != nums[k]) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 2147483647
        int value = Integer.MAX_VALUE % 1000000000;
        System.out.println(isPalindrome(121));
    }
}
