package Algorithm.work1013;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n <= 2 || n >= 10000)
            return;
        int m = scan.nextInt();
        if (m <= 0 || m >= n -1)
            return;
        for(int i=0; i<n; i++)
            list.add(scan.nextInt());
        for(int i=0; i<m; i++){
            Collections.sort(list);
            int tmp = list.get(0)+list.get(1);
            list.remove(0);
            list.remove(1);
            list.add(tmp);
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }


}
