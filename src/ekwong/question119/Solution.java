package ekwong.question119;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * <p>
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution {


    public List<Integer> getRow(int rowIndex) {
        List<Integer> integerList = new LinkedList<>();
        if (rowIndex == 0) {
            integerList.add(1);
            return integerList;
        }
        for (int i = 0; i <= rowIndex; i++) {
            BigInteger n = factorial(rowIndex);
            BigInteger m = factorial(i).multiply(factorial(rowIndex - i));
            integerList.add((n.divide(m)).intValue());
        }
        return integerList;
    }

    private BigInteger factorial(int n) {
        if (n == 0) {
            return new BigInteger("1");
        } else if (n == 1) {
            return new BigInteger("1");
        } else {
            BigInteger bigInteger = new BigInteger("" + n);
            return bigInteger.multiply(factorial(n - 1));
        }
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> tmpList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        tmpList.add(1);
        for (int i = 0; i <= rowIndex + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    curList.add(1);
                } else if (j == i - 1) {
                    curList.add(1);
                } else {
                    curList.add(tmpList.get(j - 1) + tmpList.get(j));
                }
            }
            tmpList.clear();
            tmpList.addAll(curList);
            curList.clear();
        }
        return tmpList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getRow(13));
    }
}
