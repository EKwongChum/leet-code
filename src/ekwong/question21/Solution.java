package ekwong.question21;

/**
 * @author ekwong
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            ListNode next = list2.next;
            list2.next = mergeTwoLists(list1, next);
            return list2;
        } else {
            ListNode next = list1.next;
            list1.next = mergeTwoLists(next, list2);
            return list1;
        }
    }

    /**
     * 构造一个新的链表，记录新链表的头部和尾部
     * 同时遍历两个原链表，每次找到原链表头部最小值，作为新链表的尾部
     * 直到任意一个原链表被遍历完，把另一个原链表拼接到新链表尾部
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode header;
        ListNode tail;
        if (list1.val < list2.val) {
            header = list1;
            tail = list1;
            list1 = list1.next;
        } else {
            header = list2;
            tail = list2;
            list2 = list2.next;
        }
        while (true) {
            if (list1 == null) {
                tail.next = list2;
                break;
            } else if (list2 == null) {
                tail.next = list1;
                break;
            } else {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    tail = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    tail = list2;
                    list2 = list2.next;
                }
            }
        }
        return header;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
