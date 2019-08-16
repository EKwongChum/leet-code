package ekwong.question342;

public class Solution {

    /**
     * 耗时1ms，但内存消耗太多 33.7
     *
     * @param num
     * @return
     */
    public static boolean isPowerOfFour(int num) {
        // leetcode 网站竟然认为0不是4的某个次方。。。
        if (num == 0) {
            return true;
        }
        double result = Math.log(num) / Math.log(4);
        if (Double.isNaN(result)) {
            return false;
        }
        return result % 1.0 == 0;
    }

    public static void main(String[] args) {

        System.out.println("input 16 returns " + isPowerOfFour(16));
        System.out.println("input 5 returns " + isPowerOfFour(5));
        System.out.println("input -2147483648 returns " + isPowerOfFour(-2147483648));

    }
}
