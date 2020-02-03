package ekwong.question2;

import java.math.BigInteger;

/**
 * 需要考虑数据较大的情况
 *
 * @author ekwong
 */
public class Solution {


    /**
     * Runtime: 16 ms, faster than 5.56% of Java online submissions for Add Two Numbers.
     * Memory Usage: 41.6 MB, less than 90.91% of Java online submissions for Add Two Numbers.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger n1 = new BigInteger(String.valueOf(l1.val));
        BigInteger p = new BigInteger("10");
        while (l1.next != null) {
            l1 = l1.next;
            n1 = n1.add(p.multiply(new BigInteger(String.valueOf(l1.val))));
            p = p.multiply(new BigInteger("10"));
        }

        BigInteger n2 = new BigInteger(String.valueOf(l2.val));
        BigInteger q = new BigInteger("10");
        while (l2.next != null) {
            l2 = l2.next;
            n2 = n2.add(q.multiply(new BigInteger(String.valueOf(l2.val))));
            q = q.multiply(new BigInteger("10"));
        }
        BigInteger sum = n1.add(n2);
        int num = sum.mod(new BigInteger("10")).intValue();
        sum = sum.divide(new BigInteger("10"));
        ListNode node = new ListNode(num);
        if (sum.compareTo(new BigInteger("0")) > 0) {
            generate(node, sum);
        }
        return node;
    }

    private void generate(ListNode node, BigInteger sum) {
        int num = sum.mod(new BigInteger("10")).intValue();
        sum = sum.divide(new BigInteger("10"));
        ListNode newNode = new ListNode(num);
        node.next = newNode;
        if (sum.compareTo(new BigInteger("0")) > 0) {
            generate(newNode, sum);
        }
    }

    /**
     * 竟然内存有限制，好坑哦
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int n1 = l1.val;
        int n2 = l2.val;
        int num = n1 + n2;
        int more = 0;
        if (num > 9) {
            more = 1;
            num = num % 10;
        }
        ListNode node = new ListNode(num);
        ListNode nextNode = null;
        if (l1.next != null || l2.next != null || more > 0) {
            nextNode = progress(l1, l2, more);
        }
        if (nextNode != null) {
            node.next = nextNode;
        }
        return node;
    }

    private ListNode progress(ListNode l1, ListNode l2, int more) {
        int n1, n2, num;
        if (l1.next != null) {
            l1 = l1.next;
            n1 = l1.val;
        } else {
            n1 = 0;
        }
        if (l2.next != null) {
            l2 = l2.next;
            n2 = l2.val;
        } else {
            n2 = 0;
        }
        num = n1 + n2 + more;
        if (num > 9) {
            more = 1;
            num = num % 10;
        }
        ListNode node = new ListNode(num);
        ListNode nextNode = null;
        if (l1.next != null || l2.next != null || more > 0) {
            nextNode = progress(l1, l2, more);
        }
        if (nextNode != null) {
            node.next = nextNode;
        }
        return node;
    }
}
