package ekwong.question107;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Solution {

    private Stack<List<Integer>> stack = new Stack<>();

    /**
     * Runtime: 2 ms, faster than 6.90% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 43.1 MB, less than 5.00% of Java online submissions for Binary Tree Level Order Traversal II.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            int firstValue = root.val;
            List<Integer> firstList = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            firstList.add(firstValue);
            stack.push(firstList);
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            levelInteger(nodeList);
            while (!stack.isEmpty()) {
                lists.add(stack.pop());
            }
        }
        return lists;
    }

    private void levelInteger(List<TreeNode> nodeList) {
        List<Integer> integerList = new ArrayList<>();
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            integerList.add(node.val);
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        if (integerList.size() != 0) {
            stack.push(integerList);
        }
        if (nodeList.size() != 0) {
            levelInteger(nextNodeList);
        }
    }

}
