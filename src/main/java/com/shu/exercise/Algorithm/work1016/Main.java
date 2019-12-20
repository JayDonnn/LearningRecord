package Algorithm.work1016;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<String> strings = new ArrayList<>();
        String tmp = null;
        for (int i = 0; i < input.length(); i++) {
            tmp = input.substring(i, i+1);
            if(!strings.contains(tmp))
                strings.add(tmp);
        }

        int n = strings.size();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = input.indexOf(strings.get(i));
            arr[i][1] = input.lastIndexOf(strings.get(i));
        }

        int last = -1;
        int big = arr[0][1];
        for (int i = 0; i < n; i++) {
            if(big < arr[i][0]){
                System.out.print((big - last) + " ");
                last = big;
                big = arr[i][1];
            }else if(big < arr[i][1]){
                big = arr[i][1];
            }
        }
        System.out.println(big - last);
    }
}
