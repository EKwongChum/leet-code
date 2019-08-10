package ekwong.question504;

import java.util.Iterator;
import java.util.Stack;

public class Solution {

    public static String convertToBase7(int num) {
        int a = Math.abs(num);
        boolean end = false;
        Stack<String> stack = new Stack<>();
        while (!end) {
            int y = a % 7;
            int s = a / 7;
            if (s < 7) {
                end = true;
                stack.push(String.valueOf(y));
                if (s != 0) {
                    stack.push(String.valueOf(s));
                }
            } else {
                stack.push(String.valueOf(y));
            }
            a = s;
        }
        if (num < 0) {
            stack.push("-");
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(101));
        System.out.println(convertToBase7(0));
    }
}
