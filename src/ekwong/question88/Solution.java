package ekwong.question88;

import java.util.Stack;

public class Solution {

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        Stack<Integer> stack = new Stack<>();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (index1 == m || index2 == n) {
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                stack.push(nums1[index1]);
                index1 += 1;
            } else {
                stack.push(nums2[index2]);
                index2 += 1;
            }
        }
        if (index1 == m && index2 != n) {
            for (int i = index2; i < n; i++) {
                stack.push(nums2[i]);
            }
        } else if (index2 == n && index1 != m) {
            for (int i = index1; i < m; i++) {
                stack.push(nums1[i]);
            }
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            nums1[i] = stack.pop();
        }

        for (int number : nums1) {
            System.out.println(number);
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        Stack<Integer> stack = new Stack<>();
        int index1 = 0, index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if ((index1 ^ m) == 0 || (index2 ^ n) == 0) {
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                stack.push(nums1[index1]);
                index1 += 1;
            } else {
                stack.push(nums2[index2]);
                index2 += 1;
            }
        }
        if ((index1 ^ m) == 0 && (index2 ^ n) != 0) {
            for (int i = index2; i < n; i++) {
                stack.push(nums2[i]);
            }
        } else if ((index2 ^ n) == 0 && (index1 ^ m) != 0) {
            for (int i = index1; i < m; i++) {
                stack.push(nums1[i]);
            }
        }
        for (int i = nums1.length - 1; i >= 0; i--) {
            nums1[i] = stack.pop();
        }

        for (int number : nums1) {
            System.out.println(number);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array = new int[nums1.length];
        int index1 = 0, index2 = 0, index = 0;
        for (int i = 0; i < m + n; i++) {
            if ((index1 ^ m) == 0 || (index2 ^ n) == 0) {
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                array[i] = nums1[index1];
                index1 += 1;
            } else {
                array[i] = nums2[index2];
                index2 += 1;
            }
            index += 1;
        }
        if ((index1 ^ m) == 0 && (index2 ^ n) != 0) {
            for (int i = index2; i < n; i++) {
                array[index] = nums2[i];
                index += 1;
            }
        } else if ((index2 ^ n) == 0 && (index1 ^ m) != 0) {
            for (int i = index1; i < m; i++) {
                array[index] = nums1[i];
                index += 1;
            }
        }
        nums1 = array;

        for (int number : nums1) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);
    }
}
