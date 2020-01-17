package ekwong.question108;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Solution {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 45.1 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
            TreeNode node = new TreeNode(nums[0]);
            node.right = new TreeNode(nums[1]);
            return node;
        } else {
            int mid = nums.length / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = subTree(nums, 0, mid - 1);
            node.right = subTree(nums, mid + 1, nums.length - 1);
            return node;
        }
    }

    private TreeNode subTree(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        } else if (endIndex - startIndex == 1) {
            TreeNode node = new TreeNode(nums[startIndex]);
            node.right = new TreeNode(nums[endIndex]);
            return node;
        } else {
            int mid = (endIndex + startIndex) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = subTree(nums, startIndex, mid - 1);
            node.right = subTree(nums, mid + 1, endIndex);
            return node;
        }
    }
}
