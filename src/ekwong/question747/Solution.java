package ekwong.question747;

/**
 * 题目逻辑有问题，建议跳过这题
 */
public class Solution {

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return -1;
        } else {
            int index = 0, maxNum = nums[0], bigNum = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > maxNum) {
                    bigNum = maxNum;
                    index = i;
                    maxNum = nums[i];
                } else if (nums[i] > bigNum && nums[i] != maxNum) {
                    bigNum = nums[i];
                }
            }
            if (bigNum != 0 && (maxNum != bigNum) && maxNum / bigNum < 2) {
                return -1;
            }
            return index;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 1, 6, 0};
        int[] nums2 = {18, 66, 24, 29, 57, 54, 84, 16, 29, 71, 22, 33, 98, 34, 20, 65, 21, 6, 11, 74, 7, 93, 40, 64, 97, 56, 3, 72, 63, 67, 72, 86, 42, 29, 34, 46, 97, 34, 45, 82, 22, 80, 94, 45, 46, 96, 10, 34, 98, 55};
        int[] nums3 = {0, 1, 1, 2};
        int[] nums4 = {1, 2, 16, 35, 44, 100, 27, 0};
        int[] nums5 = {0, 0, 3, 2};
//        System.out.println("nums1 returns " + dominantIndex(nums1));
        System.out.println("nums2 returns " + dominantIndex(nums2));
//        System.out.println("nums3 returns " + dominantIndex(nums3));
//        System.out.println("nums4 returns " + dominantIndex(nums4));
//        System.out.println("nums5 returns " + dominantIndex(nums5));

    }
}
