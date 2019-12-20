package Algorithm.work1029;

/**
 * 反转链表 https://leetcode-cn.com/problems/reverse-linked-list
 */

class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}

public class ReverseLinkedList {

    private static Node reverseLinkedListIteratively(Node head){
        Node cur, pre, next;
        cur = head;
        pre = null;
        next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * mark to review
     * @param head
     * @return
     */
    private static Node reverseLinkedListRecursively(Node head){
        if(head == null || head.next == null) {
            return head;
        }
        Node p = reverseLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;
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
//        Node res = reverseLinkedListIteratively(n1);
        Node res = reverseLinkedListRecursively(n1);
        System.out.println();
    }
}
