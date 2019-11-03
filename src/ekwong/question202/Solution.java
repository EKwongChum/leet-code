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
        Set<Integer> recordSet = new HashSet<>();
        int remain, squareSum;
        while (recordSet.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int a = 19;
        int b = 95;
        System.out.println("a returns " + isHappy(a));
        System.out.println("b returns " + isHappy(b));

    }
}
