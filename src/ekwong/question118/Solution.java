package ekwong.question118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new LinkedList<>();
        if (numRows == 0) {
            return listList;
        }
        if (numRows == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            listList.add(list);
            return listList;
        }
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> curList = new ArrayList<>();
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
            listList.add(curList);
        }
        return listList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }
}
