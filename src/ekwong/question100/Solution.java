package ekwong.question100;

public class Solution {

    /**
     * 又一次双100%，嘻嘻，自己想出来的
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Same Tree.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (p.left == null && q.left != null) {
            return false;
        }
        if (p.right == null && q.right != null) {
            return false;
        }
        if (q.left == null && p.left != null) {
            return false;
        }
        if (q.right == null && p.right != null) {
            return false;
        }
        if (p.left != null && p.right != null) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p.left != null) {
            return isSameTree(p.left, q.left);
        } else if (p.right != null) {
            return isSameTree(p.right, q.right);
        } else {
            return true;
        }
    }
}
