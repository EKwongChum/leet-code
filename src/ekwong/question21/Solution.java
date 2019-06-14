package ekwong.question21;

/**
 * @author ekwong
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
