package Algorithm.work1101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下述四个操作
 * push(x)--将一个元素入栈
 * pop()--移除栈顶元素
 * peek()--获取栈顶元素
 * empty()--返回栈是否为空
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */

public class ImplementStackUsingQueues1 {


    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack.
     *  O(1)
     * */
    public void push(int x) {
        queue1.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element.
     *  O(n)
     * */
    public int pop() {
        int tempTop = top;
        while (queue1.size() > 1) {
            int elem = queue1.poll();
            if(queue1.size() == 1) {
                top = elem;
            }
            queue2.offer(elem);
        }
        queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return tempTop;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues1 implementStackUsingQueues1 = new ImplementStackUsingQueues1();
        implementStackUsingQueues1.push(1);
        implementStackUsingQueues1.push(2);
        System.out.println(implementStackUsingQueues1.pop());
        System.out.println(implementStackUsingQueues1.top());
    }
}
