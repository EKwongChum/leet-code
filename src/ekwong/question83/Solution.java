package ekwong.question83;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class Solution {

    private HashSet<Integer> set = new HashSet<>();

    /**
     * 竟然内存使用战胜100%了，意外
     * 思路就是用一个新的链表，判断旧链表的每一个节点是否已存在。
     *
     * Runtime: 2 ms, faster than 6.87% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }
        set.add(head.val);
        ListNode newHead = new ListNode(head.val);
        rm(head.next, newHead);
        return newHead;
    }

    private void rm(ListNode oldNode, ListNode newNode) {
        if (oldNode != null) {
            int oldVal = oldNode.val;
            if (set.contains(oldVal)) {
                ListNode nextNode = oldNode.next;
                rm(nextNode, newNode);
            } else {
                set.add(oldVal);
                ListNode node = new ListNode(oldVal);
                newNode.next = node;
                rm(oldNode.next, node);
            }
        }
    }


}

