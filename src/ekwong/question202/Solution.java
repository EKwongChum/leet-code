package ekwong.question202;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * 没能解出来，这个是抄别人的答案
     *
     * @param n
     * @return
     */
    private static boolean isHappy(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        String num = String.valueOf(n);
        int sum = 0;
        for (char c : num.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(c));
            sum = sum + (i * i);
        }
        return isHappy(sum);
    }


    public static void main(String[] args) {
        int a = 19;
        int b = 95;
        System.out.println("a returns " + isHappy(a));
        System.out.println("b returns " + isHappy(b));

    }
}
