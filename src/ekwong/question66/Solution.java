package ekwong.question66;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    /**
     * 给定一个数组，返回该数组的值 + 1 的数组
     * <p>
     * 解法：从数组最后一位开始，把该位+1；
     * 若当前位大于9，则当前位置为0，左一位+1
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        boolean plus = true;
        boolean prefix = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plus) {
                int tmp = digits[i] + 1;
                if (tmp > 9) {
                    if (i == 0) {
                        prefix = true;
                    }
                    digits[i] = 0;
                } else {
                    plus = false;
                    digits[i] += 1;
                }
            }
        }
        if (prefix) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 9, 9};
        int[] result = plusOne(array);
        System.out.println(Arrays.stream(result).toArray());
    }
}
