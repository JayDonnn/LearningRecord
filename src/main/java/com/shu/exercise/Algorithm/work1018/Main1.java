package Algorithm.work1018;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int[] c = new int[a.length];
        int[] d = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = Integer.parseInt(a[i]);
            d[i] = Integer.parseInt(b[i]);
        }

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(c[i] >= list.get(j))
                    array.add(j);
            }
            list.add(d[i]);

            for (int j = 0; j < array.size(); j++) {
                list.remove((int)array.get(j));
            }
//            Iterator<Integer> iterator = list.iterator();
//            while (iterator.hasNext()){
//                list.remove((int))
//            }
            array.clear();

            if(max < list.size())
                max = list.size();
        }
        System.out.println(max);
    }
}
