package ekwong.question205;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class Solution {

    /**
     * 调整输入，这样s字符串可以得到t，t字符串可以得到s，同时成立时，才是正确
     * 缺点是遍历次数太多
     *
     * Runtime: 11 ms, faster than 44.10% of Java online submissions for Isomorphic Strings.
     * Memory Usage: 38 MB, less than 49.12% of Java online submissions for Isomorphic Strings.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        return isSame(s, t) && isSame(t, s);
    }

    private boolean isSame(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : s.toCharArray()) {
            builder.append(map.get(c));
        }
        return t.equals(builder.toString());
    }

    /**
     * 用两个hashmap，这样只需要遍历一次
     * Runtime: 6 ms, faster than 73.43% of Java online submissions for Isomorphic Strings.
     * Memory Usage: 37.6 MB, less than 89.47% of Java online submissions for Isomorphic Strings.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (sMap.get(sChar) != null) {
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } else if (tMap.get(tChar) != null) {
                if (tMap.get(tChar) != sChar) {
                    return false;
                }
            } else {
                sMap.put(sChar, tChar);
                tMap.put(tChar, sChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";
        String s4 = "ab", t4 = "aa";
        Solution solution = new Solution();
        System.out.println("1 returns " + solution.isIsomorphic(s1, t1));
        System.out.println("2 returns " + solution.isIsomorphic(s2, t2));
        System.out.println("3 returns " + solution.isIsomorphic(s3, t3));
        System.out.println("4 returns " + solution.isIsomorphic(s4, t4));

    }
}
