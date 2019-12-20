package Algorithm.work1009;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> supStack = new Stack<>();

    public void push(Integer item){
        stack.push(item);
        if(supStack.size() == 0){
            supStack.push(item);
        } else {
            Integer temp = stack.peek();
            if(temp.intValue() > item.intValue())
                supStack.push(item);
            else
                supStack.push(temp);
        }
    }

    public Integer pop(){
        if(stack.size() > 0 && supStack.size() > 0){
            supStack.pop();
            return stack.pop();
        }
        return null;
    }

    public Integer min(){
        if(stack.size() > 0 && supStack.size() > 0)
            return supStack.peek();
        return null;
    }

    public static void main(String[] args) {
        MinStack integerMinStack = new MinStack();
        integerMinStack.push(3);
        integerMinStack.push(4);
        integerMinStack.push(2);
        integerMinStack.push(1);
        System.out.println(integerMinStack.min());
        integerMinStack.pop();
        integerMinStack.push(5);
        System.out.println(integerMinStack.min());
    }
}
