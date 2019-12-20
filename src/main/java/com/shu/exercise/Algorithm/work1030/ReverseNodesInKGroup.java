package Algorithm.work1030;

/**
 * 以k个节点为一组，反转整个链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */

public class ReverseNodesInKGroup {

    private static Node reverseKGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node pre = dummy;
        Node end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = reverse(head.next);
        Node next = head.next;
        head.next = next.next;
        next.next = head;
        return p;
    }

    public static void main(String[] args) {
        Node n1, n2, n3, n4, n5;
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node res1 = reverseKGroup(n1, 2);
        Node res2 = reverseKGroup(n1, 3);
        System.out.println();
    }
}
