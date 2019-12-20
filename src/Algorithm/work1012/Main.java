package Algorithm.work1012;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split(",");
        if(split.length != 2)
            return;
        long start = Long.parseLong(split[0]);
        long end = Long.parseLong(split[1]);
        if(start < 1 || end > 2000000000 || start >= end)
            return;
        int cnt = 0;
        for (long i = start; i <= end; i++) {
            if(isZDN(i))
                cnt++;
        }
        System.out.println(cnt);

    }

    private static boolean isZDN(long num) {
        int zeroCnt = 0;
        int oneCnt = 0;
        while (num > 0){
            if((num & 1) == 1)
                oneCnt++;
            else
                zeroCnt++;
            num = num >> 1;
        }
        if(zeroCnt >= oneCnt)
            return true;
        else
            return false;
    }

}
