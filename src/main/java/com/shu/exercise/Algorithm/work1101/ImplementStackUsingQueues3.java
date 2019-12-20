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

public class ImplementStackUsingQueues3 {

    /**
     * 用一个队列实现
     * 核心思想：每次push一个元素之后翻转队列
     */
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues3() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size > 1) {
            queue.offer(queue.poll());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues3 implementStackUsingQueues3 = new ImplementStackUsingQueues3();
        implementStackUsingQueues3.push(1);
        implementStackUsingQueues3.push(2);
        implementStackUsingQueues3.push(3);
//        System.out.println(implementStackUsingQueues3.pop());
        System.out.println(implementStackUsingQueues3.top());
    }
}
