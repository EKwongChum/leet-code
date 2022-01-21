package ekwong.question28;

public class Solution {
    /**
     * 若 needle 为空字符串，返回 0
     * 遍历 haystack，若遇到与 needle 相同的头字母，对比当前接下来的部分
     * 若接下来的部分完全相同，则认为首字母的 index
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        } else {
            if (!"".equals(haystack)) {
                char[] hArray = haystack.toCharArray();
                for (int i = 0; i < hArray.length; i++) {
                    if (hArray[i] == needle.charAt(0) && needle.length() <= hArray.length - i) {
                        if (needle.equals(haystack.substring(i, i + needle.length()))) {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String h = "abcdef";
        String n = "de";
        int index = strStr(h, n);
        System.out.println(index);
    }
}
