package ekwong.question111;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 *
 * @author ekwong
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left != null && root.right == null) {
                return 1 + depth(root);
            } else if (root.left == null) {
                return 1 + depth(root);
            } else {
                int leftDepth = minDepth(root.left) + 1;
                int rightDepth = minDepth(root.right) + 1;
                return Math.min(leftDepth, rightDepth);
            }
        }
    }

    private int depth(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left != null && node.right == null) {
            return 1;
        } else if (node.left == null) {
            return 1;
        } else {
            int leftDepth = minDepth(node.left) + 1;
            int rightDepth = minDepth(node.right) + 1;
            return Math.min(leftDepth, rightDepth);
        }
    }

}
