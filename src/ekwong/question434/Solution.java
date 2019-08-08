package ekwong.question434;

public class Solution {
    public static int countSegments(String s) {
        int count = 0;
        boolean found = false;
        for (char c : s.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                if (!found) {
                    count++;
                    found = true;
                }
            } else {
                found = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "Hello, my name is John";
        String s2 = "Hello, my name is  John";
        String s3 = "";
        String s4 = "    ";
        String s5 = "    foo    bar  ";

        System.out.println("s1's count  = " + countSegments(s1));
        System.out.println("s2's count  = " + countSegments(s2));
        System.out.println("s3's count  = " + countSegments(s3));
        System.out.println("s4's count  = " + countSegments(s4));
        System.out.println("s5's count  = " + countSegments(s5));
    }
}
