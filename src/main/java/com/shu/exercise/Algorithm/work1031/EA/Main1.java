package Algorithm.work1031.EA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * EA China 笔试题
 * 输入2，12，求[2,12]中是ZDN的数的个数
 * ZDN:二进制表示中，0的个数大于等于1的个数的数
 */

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] split = input.split(",");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        if(start < 1 || end > 2000000000)
            return;
        int res = findZDN(start, end);
        System.out.println(res);
    }

    private static int findZDN(int start, int end) {
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            int num = i;
            int oneNum = 0;
            int zeroNum = 0;
            while (num > 0) {
                if ((num & 1) == 1){
                    oneNum++;
                } else {
                    zeroNum++;
                }
                num >>= 1;
            }
            if(zeroNum >= oneNum) {
                cnt++;
            }
        }
        return cnt;
    }
}
