package Algorithm.work1030;

/**
 * 1.判断链表中是否有循环
 * https://leetcode-cn.com/problems/linked-list-cycle
 * 2.找出循环的入口节点
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 */

import java.util.HashSet;

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}

public class LinkedListCycle {

    private static boolean hasCycleBySet(Node head) {
        HashSet<Node> nodeHashSet = new HashSet<>();
        while (head != null) {
            if(nodeHashSet.contains(head)) {
                return true;
            } else {
                nodeHashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    private static boolean hasCycleTwoPrinter(Node head) {
        if(head == null || head.next == null) {
            return false;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private static Node findCycleEntrance(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        Node meetNode = slow;
        int cycleLength = 1;
        while (slow.next != meetNode) {
            cycleLength++;
            slow = slow.next;
        }
        slow = head;
        fast = head;
        while (cycleLength > 0) {
            fast = fast.next;
            cycleLength--;
        }

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node n1, n2, n3, n4, n5, n6;
        n1 = new Node(3);
        n2 = new Node(2);
        n3 = new Node(0);
        n4 = new Node(4);
//        n5 = new Node(5);
//        n6 = new Node(6);

        n1.next = n2;
        n2.next = n1;
//        n3.next = n4;
//        n4.next = n2;
//        n5.next = n6;
//        n6.next = n3;

//        System.out.println(hasCycleTwoPrinter(n1));
        System.out.println(findCycleEntrance(n1).val);
    }
}
