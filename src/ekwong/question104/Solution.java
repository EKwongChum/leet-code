package ekwong.question104;

import com.sun.istack.internal.NotNull;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * return its depth = 3.
 */
public class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 43.6 MB, less than 5.38% of Java online submissions for Maximum Depth of Binary Tree.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = 1, right = 1;
            if (root.left != null) {
                left = countDepth(root.left, 2);
            }
            if (root.right != null) {
                right = countDepth(root.right, 2);
            }
            return Math.max(left, right);
        }
    }

    /**
     * @param node  当前节点
     * @param level 当前节点的层级
     * @return
     */
    private int countDepth(@NotNull TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return level;
        } else {
            int leftDepth = level;
            int rightDepth = level;
            if (node.left != null) {
                leftDepth = countDepth(node.left, level + 1);
            }
            if (node.right != null) {
                rightDepth = countDepth(node.right, level + 1);
            }
            return Math.max(leftDepth, rightDepth);
        }
    }
}
