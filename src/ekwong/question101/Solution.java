package ekwong.question101;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 38.2 MB, less than 69.39% of Java online submissions for Symmetric Tree.
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return bothSymmetric(root.left, root.right);
        }
    }

    /**
     * 先判断当前两节点是否全部为空或全非空
     * 然后判断两节点的左右端空的情况
     * 再对成比较
     * 比较时记得要判空和数值比较
     *
     * @param leftNode  左边的节点
     * @param rightNode 右边的节点
     * @return
     */
    private boolean bothSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode != null) {
            return false;
        }
        if (leftNode != null && rightNode == null) {
            return false;
        }
        if (leftNode == null) {
            return true;
        }
        if (leftNode.left != null && rightNode.right == null) {
            return false;
        }
        if (leftNode.left == null && rightNode.right != null) {
            return false;
        }
        if (leftNode.right != null && rightNode.left == null) {
            return false;
        }
        if (leftNode.right == null && rightNode.left != null) {
            return false;
        }
        if ((leftNode.left != null && leftNode.right == null) && (leftNode.val == rightNode.val)) {
            return bothSymmetric(leftNode.left, rightNode.right);
        }
        if ((leftNode.right != null && leftNode.left == null) && (leftNode.val == rightNode.val)) {
            return bothSymmetric(leftNode.right, rightNode.left);
        }
        if (leftNode.right != null && leftNode.left != null && leftNode.val == rightNode.val) {
            return bothSymmetric(leftNode.left, rightNode.right) && bothSymmetric(leftNode.right, rightNode.left);
        } else {
            return leftNode.val == rightNode.val;
        }
    }

}
