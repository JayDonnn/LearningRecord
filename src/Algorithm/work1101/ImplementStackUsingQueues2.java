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

public class ImplementStackUsingQueues2 {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack.
     *  O(N)
     * */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element.
     *  O(1)
     * */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues2 implementStackUsingQueues2 = new ImplementStackUsingQueues2();
        implementStackUsingQueues2.push(1);
        implementStackUsingQueues2.push(2);
        System.out.println(implementStackUsingQueues2.top());
        System.out.println(implementStackUsingQueues2.pop());
        System.out.println(implementStackUsingQueues2.empty());
    }
}
