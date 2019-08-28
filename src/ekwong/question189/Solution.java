package ekwong.question189;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Solution {

    /**
     * time 40ms
     * memory 37mb
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (1 == nums.length || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
        System.out.println("k = " + k + " and nums = " + Arrays.toString(nums));
    }

    /**
     * time 2ms
     * memory 37mb
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (1 == nums.length || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(nums.length * 4);
        for (int i = k; i > 0; i--) {
            byteBuffer.putInt(nums[nums.length - i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            byteBuffer.putInt(nums[i]);
        }
        byteBuffer.position(0);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = byteBuffer.getInt();
        }
        System.out.println("k = " + k + " and nums = " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        int[] nums3 = {1, 2};
        int k3 = 3;
        rotate(nums1, k1);
        rotate(nums2, k2);
        rotate(nums3, k3);
    }
}
