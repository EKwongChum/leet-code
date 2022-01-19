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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
