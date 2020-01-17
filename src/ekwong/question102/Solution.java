package ekwong.question102;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            List<List<Integer>> listList = new ArrayList<>();
            List<Integer> integerList = new ArrayList<>();
            integerList.add(root.val);
            listList.add(integerList);
            List<TreeNode> nodeList = new ArrayList<>();
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            if (nodeList.size() != 0) {
                updateList(nodeList, listList);
            }
            return listList;
        }
    }

    private void updateList(List<TreeNode> nodeList, List<List<Integer>> listList) {
        List<Integer> integerList = new ArrayList<>();
        List<TreeNode> newNodeList = new ArrayList<>();
        for (TreeNode node : nodeList) {
            integerList.add(node.val);
            if (node.left != null) {
                newNodeList.add(node.left);
            }
            if (node.right != null) {
                newNodeList.add(node.right);
            }
        }
        if (integerList.size() > 0) {
            listList.add(integerList);
        }
        if (newNodeList.size() != 0) {
            updateList(newNodeList, listList);
        }
    }

}