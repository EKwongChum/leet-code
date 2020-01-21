package ekwong.question113;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 *
 * @author ekowng
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        return null;
    }

    /**
     * Runtime: 2 ms, faster than 36.05% of Java online submissions for Path Sum II.
     * Memory Usage: 48.5 MB, less than 6.06% of Java online submissions for Path Sum II.
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            List<List<Integer>> listList = new ArrayList<>();
            if (root.left == null && root.right == null) {
                if (sum == root.val) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(sum);
                    listList.add(integerList);
                } else {
                    return new ArrayList<>();
                }
            } else if (root.left != null && root.right == null) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(root.val);
                processDown(root.left, sum - root.val, integerList, listList);
            } else if (root.left == null) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(root.val);
                processDown(root.right, sum - root.val, integerList, listList);
            } else {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(root.val);
                processDown(root.left, sum - root.val, integerList, listList);
                processDown(root.right, sum - root.val, integerList, listList);
            }
            return listList;
        }
    }

    private void processDown(TreeNode node, int sum, List<Integer> integerList, List<List<Integer>> listList) {
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                List<Integer> integers = new ArrayList<>(integerList);
                integers.add(node.val);
                listList.add(integers);
            }
        } else if (node.left != null && node.right == null) {
            List<Integer> integers = new ArrayList<>(integerList);
            integers.add(node.val);
            processDown(node.left, sum - node.val, integers, listList);
        } else if (node.left == null) {
            List<Integer> integers = new ArrayList<>(integerList);
            integers.add(node.val);
            processDown(node.right, sum - node.val, integers, listList);
        } else {
            List<Integer> integers = new ArrayList<>(integerList);
            integers.add(node.val);
            processDown(node.left, sum - node.val, integers, listList);
            processDown(node.right, sum - node.val, integers, listList);
        }
    }

}
