package Algorithm.work1029;

/**
 * 成对的反转链表  https://leetcoed-cn.com/problems/swap-nodes-in-pairs
 * 例子 1->2->3->4->5->null  转换后   2->1->4->3->5->null
 * mark to review
 */
public class SwapNodesInPairs {
    private static Node swapLinkedListRecursively(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        head.next = swapLinkedListRecursively(next.next);
        next.next = head;
        return next;
    }

    private static Node swapLinkedListIteratively(Node head){
        Node pre = new Node(0);
        Node tmp;
        pre.next = head;
        tmp = pre;
        while (tmp.next != null && tmp.next.next != null) {
            Node start, end;
            start = tmp.next;
            end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        Node n1, n2, n3, n4, n5;
        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
//        n4 = new Node(4);
//        n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        Node res = swapLinkedListRecursively(n1);
        Node res = swapLinkedListIteratively(n1);
        System.out.println();
    }
}
