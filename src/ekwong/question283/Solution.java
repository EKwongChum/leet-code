package ekwong.question283;

import java.util.Arrays;

public class Solution {
    private static void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - count) {
                break;
            }
            count = moveForward(i, nums, count);
        }
    }

    private static int moveForward(int startIndex, int[] nums, int count) {
        if (nums[startIndex] == 0) {
            for (int i = startIndex; i < nums.length - 1 - count; i++) {
                nums[i] = nums[i + 1];
            }
            if (count == nums.length - 1 - startIndex) {
                return count;
            }
            nums[nums.length - 1 - count] = 0;
            count++;

            if (count == nums.length - 1) {
                return count;
            }
            if (nums[startIndex] == 0) {
                count = moveForward(startIndex, nums, count);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
