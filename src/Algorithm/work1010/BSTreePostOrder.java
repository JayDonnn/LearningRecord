package Algorithm.work1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BSTreePostOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(",");
        int length = split.length;
        int[] numArr = new int[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(isPostOrder(numArr));
    }

    private static boolean isPostOrder(int[] numArr) {
        if(numArr.length == 0 || numArr == null)
            return false;
        return helper(numArr, 0, numArr.length-1);
    }

    private static boolean helper(int[] numArr, int start, int end) {
        int i = start;
        int j = end;
        if(i == j)
            return true;

        while (numArr[i] < numArr[end]) i++;

        for (int k = i; k < end; k++) {
            if(numArr[k] < numArr[end])
                return false;
        }

        return helper(numArr, start, i-1) && helper(numArr, i, end - 1);
    }
}
