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
    public static int lengthOfLongestSubstring(String s) {
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
