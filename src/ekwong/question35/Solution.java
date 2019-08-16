package ekwong.question35;

public class Solution {


    /**
     * 竟然双100%，有点意外
     * 耗时0ms，内存消耗38M
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                if (i > 0) {
                    if (nums[i - 1] == target) {
                        return i - 1;
                    } else {
                        return i;
                    }
                } else {
                    return 0;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        int[] nums5 = {1};
        int target5 = 1;

        System.out.println("1 returns " + searchInsert(nums1, target1));
        System.out.println("2 returns " + searchInsert(nums2, target2));
        System.out.println("3 returns " + searchInsert(nums3, target3));
        System.out.println("4 returns " + searchInsert(nums4, target4));
        System.out.println("5 returns " + searchInsert(nums5, target5));
    }
}
