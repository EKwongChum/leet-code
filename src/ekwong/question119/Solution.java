package ekwong.question119;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> tmpList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        tmpList.add(1);
        for (int i = 0; i <= rowIndex+1; i++) {
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
}
