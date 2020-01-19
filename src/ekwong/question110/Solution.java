package ekwong.question110;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class Solution {

    /**
     * 从104题抄过来的，囧
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (root.left == null && root.right == null) {
                return true;
            } else if (root.left == null) {
                return root.right.left == null && root.right.right == null;
            } else if (root.right == null) {
                return root.left.left == null && root.left.right == null;
            } else {
                int leftHeight = maxDepth(root.left);
                int rightHeight = maxDepth(root.right);
                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return false;
                } else {
                    return isBalanced(root.left) && isBalanced(root.right);
                }
            }
        }
    }

    private int maxDepth(TreeNode root) {
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
    private int countDepth(TreeNode node, int level) {
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

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (root.left == null && root.right == null) {
                return true;
            } else if (root.left == null) {
                return root.right.left == null && root.right.right == null;
            } else if (root.right == null) {
                return root.left.left == null && root.left.right == null;
            } else {
                int leftHeight = subTreeHeight(root.left);
                int rightHeight = subTreeHeight(root.right);
                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return false;
                } else {
                    return isBalanced1(root.left) && isBalanced1(root.right);
                }
            }
        }
    }

    private int subTreeHeight(TreeNode node) {
        int height1, height2;
        if (node.left != null) {
            if (node.left.left != null || node.left.right != null) {
                height1 = 3;
            } else {
                height1 = 2;
            }
        } else {
            height1 = 1;
        }
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                height2 = 3;
            } else {
                height2 = 2;
            }
        } else {
            height2 = 1;
        }
        return Math.max(height1, height2);
    }
}
