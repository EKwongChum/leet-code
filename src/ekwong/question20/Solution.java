package ekwong.question20;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Runtime: 1 ms, faster than 98.69% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37.7 MB, less than 5.06% of Java online submissions for Valid Parentheses.
     *
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        // 空字符串
        if (s.length() == 0) {
            return true;
        }
        // 如果字符串长度是奇数，必然不符合要求
        if ((s.length() & 1) == 1) {
            return false;
        }
        List<Character> windowList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (windowList.size() == 0) {
                windowList.add(c);
            } else {
                if (compare(windowList.get(windowList.size() - 1), c)) {
                    windowList.remove(windowList.size() - 1);
                } else {
                    windowList.add(c);
                }
            }
        }
        return windowList.size() == 0;
    }

    private boolean compare(Character a, Character b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return a == '{' && b == '}';
    }

    public static void main(String[] args) {
        String test1 = "(([]){})";
        Solution solution = new Solution();
        System.out.println("result" + solution.isValid1(test1));
    }

}
