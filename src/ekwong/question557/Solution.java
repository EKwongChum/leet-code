package ekwong.question557;

/**
 * @author ekwong
 */
public class Solution {

    public String reverseWords(String s) {
        String[] strings = s.split("\\s");
        if (strings.length > 0) {
            for (int i = 0; i < strings.length; i++) {
                String child = strings[i];
                StringBuilder temp = new StringBuilder();
                for (int j = child.length(); j > 0; j--) {
                    String littleChild = child.substring(j - 1, j);
                    temp.append(littleChild);
                }
                strings[i] = temp.toString();
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            String child = strings[i];
            builder.append(" ").append(child);
        }
        return builder.toString();
    }


    /**
     * 效率堪忧，占用内存大
     *
     * @param s
     * @return
     */
    public String reverseWord(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        StringBuilder outBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char child = charArray[i];
            if (Character.isSpaceChar(child) || i == charArray.length - 1) {
                if (i == charArray.length - 1) {
                    builder.append(child);
                }
                String newString = builder.toString();
                StringBuilder temp = new StringBuilder();
                for (int j = newString.length(); j > 0; j--) {
                    String littleChild = newString.substring(j - 1, j);
                    temp.append(littleChild);
                }
                outBuilder.append(temp);
                if (i != charArray.length - 1) {
                    outBuilder.append(" ");
                }
                builder = new StringBuilder();
            } else {
                builder.append(child);
            }
        }
        String almost = outBuilder.toString();
        return almost;
    }

}
