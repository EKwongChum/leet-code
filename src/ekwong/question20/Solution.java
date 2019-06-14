package ekwong.question20;

import java.util.Stack;

/**
 * @author ekwong
 */
public class Solution {

    public boolean isValid(String s) {
        // 空字符串
        if (s.length() == 0) {
            return true;
        }
        // 如果字符串长度是奇数，必然不符合要求
        if ((s.length() & 1) == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if ((stack.peek() == '(' && c == ')')
                    || stack.peek() == '[' && c == ']'
                    || stack.peek() == '{' && c == '}') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
