package ekwong.question136;

import java.util.*;

/**
 * @author ekwong
 */
public class Solution {
    /**
     * 这个方法太慢了
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        for (int value : nums) {
            int count = 0;
            for (int num : nums) {
                if (value == num) {
                    count += 1;
                    if (count == 2) {
                        break;
                    }
                }
            }
            if (count < 2) {
                return value;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        ArrayList<Integer> okList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (okList.contains(i)) {
                continue;
            }
            if (i + 1 == nums.length) {
                return nums[i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    okList.add(i);
                    okList.add(j);
                    break;
                }
                if (j == nums.length - 1) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    /**
     * 用了位运算，内存开销击败了 99.33%，但速度依然不理想
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        for (int value : nums) {
            int count = 0;
            for (int num : nums) {
                // 如果为0，说明两数相同
                if ((value ^ num) == 0) {
                    count += 1;
                    if (count == 2) {
                        break;
                    }
                }
            }
            if (count < 2) {
                return value;
            }
        }
        return -1;
    }

    public int singleNumber4(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            // 成功会返回null
            Integer pre = map.put(nums[i], i);
            if (pre != null) {
                sum = sum - (i + pre);
            }
        }
        return nums[sum];
    }

    public int singleNumber5(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        for (int num : nums) {
            if (integerList.contains(num)) {
                integerList.remove((Integer) num);
            } else {
                integerList.add(num);
            }
        }
        return integerList.get(0);
    }

    /**
     * 速度最快了
     *
     * @param nums
     * @return
     */
    public int singleNumber6(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
