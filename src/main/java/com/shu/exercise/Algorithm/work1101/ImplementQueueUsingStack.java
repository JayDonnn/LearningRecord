package Algorithm.work1101;

import java.util.Stack;

/**
 * 使用栈实现队列的下述四个操作
 * push(x)--将一个元素放入队列的尾部
 * pop()--从队列首部移除元素
 * peek()--返回队列首部的元素
 * empty()--返回队列是否为空
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack1.isEmpty()) {
            int elemS1 = stack1.pop();
            stack2.push(elemS1);
        }
        int elem = stack2.pop();
        while (!stack2.isEmpty()) {
            int elemS2 = stack2.pop();
            stack1.push(elemS2);
        }
        return elem;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack1.isEmpty()) {
            int elemS1 = stack1.pop();
            stack2.push(elemS1);
        }
        int elem = stack2.peek();
        while (!stack2.isEmpty()) {
            int elemS2 = stack2.pop();
            stack1.push(elemS2);
        }
        return elem;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack implementQueueUsingStack = new ImplementQueueUsingStack();
        implementQueueUsingStack.push(1);
        implementQueueUsingStack.push(2);
        System.out.println(implementQueueUsingStack.peek());
        System.out.println(implementQueueUsingStack.pop());
        System.out.println(implementQueueUsingStack.empty());
    }
}
