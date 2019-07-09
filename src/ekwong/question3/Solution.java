package ekwong.question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /**
     * 效率15%
     * 内存88%
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        int length = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                boolean hasSame = false;
                for (int k = i; k < j; k++) {
                    if ((chars[k] ^ chars[j]) == 0) {
                        hasSame = true;
                        break;
                    }
                }
                if (hasSame) {
                    length = j - i;
                    break;
                } else if (j == chars.length - 1) {
                    length = j - i + 1;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    /**
     * 滑动窗口法，看答案的
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        int startIndex = 0;
        char currentChar;
        int lastSameIndexPlus, interval;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {
                lastSameIndexPlus = map.get(s.charAt(i)) + 1;
                startIndex = startIndex < lastSameIndexPlus ? lastSameIndexPlus : startIndex;
            }
            map.put(currentChar, i);
            interval = i - startIndex + 1;
            maxLength = maxLength < interval ? interval : maxLength;
        }
        return maxLength;
    }

    /**
     * 递归法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        max = 0;
        divString(s, 0, s.length() - 1);
        return max;
    }

    private static int max = 0;


    private static void divString(String src, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            if (max < 1) {
                max = 1;
            }
        } else {
            boolean hasSame = false;
            for (int i = startIndex; i <= endIndex; i++) {
                List<Integer> integerList = new ArrayList<>();
                for (int j = i + 1; j <= endIndex; j++) {
                    if (src.charAt(i) == src.charAt(j)) {
                        if (!hasSame) {
                            integerList.add(i);
                        }
                        integerList.add(j);
                        hasSame = true;
                    }
                }
                if (hasSame) {
                    for (int k = 0; k < integerList.size(); k++) {
                        int nextStartIndex, nextEndIndex;
                        if (k == 0) {
                            nextStartIndex = startIndex;
                            nextEndIndex = integerList.get(k + 1) - 1;
                        } else if (k == integerList.size() - 1) {
                            nextStartIndex = integerList.get(k - 1) + 1;
                            nextEndIndex = endIndex;
                        } else {
                            nextStartIndex = integerList.get(k - 1) + 1;
                            nextEndIndex = integerList.get(k + 1) - 1;
                        }
                        divString(src, nextStartIndex, nextEndIndex);
                    }
                    break;
                }
            }
            if (!hasSame) {
                int interval = endIndex - startIndex + 1;
                if (max < interval) {
                    max = interval;
                }
            }
        }
    }


    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "download";
        System.out.println("result1:" + lengthOfLongestSubstring(s1));
        System.out.println("result2:" + lengthOfLongestSubstring(s2));
        System.out.println("result3:" + lengthOfLongestSubstring(s3));
        System.out.println("result4:" + lengthOfLongestSubstring(s4));
    }

}
