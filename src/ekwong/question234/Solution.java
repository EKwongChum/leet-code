package ekwong.question234;

import java.util.Stack;

public class Solution {
    /**
     * 判断一个链表是否为回文链表
     * 暂存链表头部
     * 遍历链表，把所有元素按顺序入栈
     * 遍历链表，每个元素与出栈元素做比较，若不同，中断遍历并返回 false
     * 遍历链表结束后，返回 true
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        Integer tmpInt;
        while (head != null) {
            tmpInt = stack.pop();
            if (head.val != tmpInt) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 3, 2, 1};
    }
}
