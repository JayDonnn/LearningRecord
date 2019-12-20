package Algorithm.work1009;

import java.util.Stack;

public class PushPopSeq {

    public static boolean isPopOrder(String pushOrder, String popOrder){
        String[] strArr1 = pushOrder.split(",");
        String[] strArr2 = popOrder.split(",");

        int length1 = strArr1.length;
        int length2 = strArr2.length;
        if(length1 != length2)
            return false;

        int[] pushArr = new int[length1];
        int[] popArr = new int[length1];

        for (int i = 0; i < length1; i++) {
            pushArr[i] = Integer.parseInt(strArr1[i]);
            popArr[i] = Integer.parseInt(strArr2[i]);
        }

        Stack<Integer> stack = new Stack<>();


        int popIndex = 0;
        int pushIndex = 0;
        while(pushIndex < length1) {
            int popItem = popArr[popIndex];
            if(stack.size() > 0 && stack.peek() == popItem){
                stack.pop();
                popIndex++;
            } else {
                if (pushIndex < length1) {
                    stack.push(pushArr[pushIndex]);
                    pushIndex++;
                }
            }
        }
        if(popIndex == length1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String pushOrder = "1,2,3,4,5";
        String popOrder1 = "4,5,3,2,1";
        String popOrder2 = "4,3,5,1,2";
        System.out.println(isPopOrder(pushOrder, popOrder1));
        System.out.println(isPopOrder(pushOrder, popOrder2));
    }

}
