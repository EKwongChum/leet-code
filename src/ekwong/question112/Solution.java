package ekwong.question112;

/**
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            if (root.left == null && root.right == null) {
                return root.val == sum;
            } else if (root.left != null && root.right == null) {
                return hasPathSum(root.left, sum - root.val);
            } else if (root.left == null) {
                return hasPathSum(root.right, sum - root.val);
            } else {
                return hasPathSum(root.left, sum - root.val)
                        || hasPathSum(root.right, sum - root.val);
            }
        }

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 45.1 MB, less than 5.88% of Java online submissions for Path Sum.
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            if (root.left == null && root.right == null) {
                return root.val == sum;
            } else if (root.left != null && root.right == null) {
                return equalsSum(root.left, root.val, sum);
            } else if (root.left == null) {
                return equalsSum(root.right, root.val, sum);
            } else {
                return equalsSum(root.left, root.val, sum) || equalsSum(root.right, root.val, sum);
            }
        }
    }

    private boolean equalsSum(TreeNode node, int current, int sum) {
        if (node.left == null && node.right == null) {
            return current + node.val == sum;
        } else if (node.left != null && node.right == null) {
            return equalsSum(node.left, node.val + current, sum);
        } else if (node.left == null) {
            return equalsSum(node.right, node.val + current, sum);
        } else {
            return equalsSum(node.left, node.val + current, sum) || equalsSum(node.right, node.val + current, sum);
        }
    }

}
