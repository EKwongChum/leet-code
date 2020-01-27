package ekwong.question103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Solution {

    /**
     * Runtime: 2 ms, faster than 7.18% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 39.9 MB, less than 5.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null) {
            return new LinkedList<>();
        } else {
            List<Integer> integerList = new LinkedList<>();
            integerList.add(root.val);
            listList.add(integerList);
            List<TreeNode> nodeList = new ArrayList<>();
            if (root.left == null && root.right == null) {
                return listList;
            } else if (root.left != null && root.right == null) {
                nodeList.add(root.left);
                levelOrder(listList, nodeList, false);
            } else if (root.left == null) {
                nodeList.add(root.right);
                levelOrder(listList, nodeList, false);
            } else {
                nodeList.add(root.left);
                nodeList.add(root.right);
                levelOrder(listList, nodeList, false);
            }
        }
        return listList;
    }

    private void levelOrder(List<List<Integer>> listList, List<TreeNode> nodeList, boolean order) {
        List<Integer> integerList = new LinkedList<>();
        if (order) {
            for (TreeNode node : nodeList) {
                integerList.add(node.val);
            }
        } else {
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                integerList.add(nodeList.get(i).val);
            }
        }
        listList.add(integerList);
        List<TreeNode> newNodeList = new LinkedList<>();
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                newNodeList.add(node.left);
            }
            if (node.right != null) {
                newNodeList.add(node.right);
            }
        }
        if (newNodeList.size() != 0) {
            levelOrder(listList, newNodeList, !order);
        }
    }

}
