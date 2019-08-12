package ekwong.question215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // 洗澡前  执行花费时间 3ms
    public static int findKthLargest1(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        System.out.println("nums = " + Arrays.toString(nums));

        return nums[k - 1];
    }

    private static void sort(int[] nums, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(nums, p, q);
            sort(nums, q + 1, r);
            merge(nums, p, q, r);
        }
    }

    private static void merge(int[] nums, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] nums1 = new int[n1 + 1];
        int[] nums2 = new int[n2 + 1];
//        if (q > 0) {
        System.arraycopy(nums, p, nums1, 0, n1);
//        }
//        if (r > 0) {
        System.arraycopy(nums, q + 1, nums2, 0, n2);
//        }
        nums1[n1] = Integer.MIN_VALUE;
        nums2[n2] = Integer.MIN_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (nums1[i] > nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }
    }

    // 洗澡后  执行花费时间 20ms
    public static int findKthLargest(int[] nums, int k) {
        int temp;
        if (k < nums.length / 2) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
                if (k - 1 == i) {
                    return nums[i];
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
                if (nums.length - k == i) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int[] nums3 = new int[]{2, 1};
        int k3 = 1;

        System.out.println("num1's " + k1 + " largest is " + findKthLargest(nums1, k1));
        System.out.println("num2's " + k2 + " largest is " + findKthLargest(nums2, k2));
        System.out.println("num3's " + k3 + " largest is " + findKthLargest(nums3, k3));

    }
}
