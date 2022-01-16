package ekwong.bytedance;

import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution {

    public static Node process(Node node, int k) {
        Node partHeader = null, header = null;
        Node lastTail = null;
        while (node != null && node.next != null) {
            Node lastItem = null;
            boolean keep = false;

            for (int i = 0; i < k; i++) {
                Node itemNode = new Node();
                itemNode.value = node.value;
                if (lastItem != null) {
                    lastItem.next = itemNode;
                    lastItem = itemNode;
                } else {
                    lastItem = itemNode;
                    partHeader = itemNode;
                }
                if (node.next != null) {
                    node = node.next;
                } else {
                    if (i < k - 1) {
                        keep = true;
                        break;
                    }
                }
            }
            Node newHeader = null;
            Node currentTail = null;
            // 调整
            if (!keep) {
                currentTail = partHeader;
                Stack<Node> stack = new Stack<>();
                for (int i = 0; i < k; i++) {
                    stack.push(partHeader);
                    partHeader = partHeader.next;
                }
                Node itemTail = null;
                while (!stack.empty()) {
                    Node pop = stack.pop();
                    if (newHeader == null) {
                        newHeader = pop;
                    } else {
                        itemTail.next = pop;
                    }
                    itemTail = pop;
                }
                if (itemTail != null) {
                    itemTail.next = null;
                }
            } else {
                newHeader = partHeader;
            }
            if (lastTail != null) {
                lastTail.next = newHeader;
            }
            lastTail = currentTail;
            if (header == null) {
                header = newHeader;
            }
        }
        return header;
    }

    public static Node array2Node(int[] array) {
        Node header = null, tmpNode = null;
        for (int n : array) {
            Node item = new Node();
            item.value = n;
            if (tmpNode == null) {
                header = item;
            } else {
                tmpNode.next = item;
            }
            tmpNode = item;
        }
        return header;
    }

    public static void printNodeList(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        Node node = array2Node(numbers);
        Node result = process(node, 3);
        printNodeList(result);
    }
}
