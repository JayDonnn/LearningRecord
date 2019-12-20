package Algorithm.work1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsSameSubNet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String ip1 = inputs[0];
        String ip2 = inputs[1];
        int maskNetBits = Integer.parseInt(inputs[2]);

        int[] maskNet = new int[32];
        int[] ip1Arr = new int[32];
        int[] ip2Arr = new int[32];

        for (int i = 0; i < maskNetBits; i++) {
            maskNet[i] = 1;
        }

        ip1Arr = transfer(ip1);
        ip2Arr = transfer(ip2);

        System.out.println(check(ip1Arr, ip2Arr, maskNet));
    }

    private static boolean check(int[] ip1Arr, int[] ip2Arr, int[] maskNet) {
        for (int i = 0; i < 32; i++) {
            ip1Arr[i] = ip1Arr[i] & maskNet[i];
            ip2Arr[i] = ip2Arr[i] & maskNet[i];
        }
        for (int i = 0; i < 32; i++) {
            if(ip1Arr[i] != ip2Arr[i])
                return false;
        }
        return true;
    }

    private static int[] transfer(String ip) {
        int[] res = new int[32];
        int cnt = 1;
        String[] init = ip.split("\\.");
        for (String part: init) {
            int dicNum = Integer.parseInt(part);
            int index = cnt * 8 - 1;
            while (dicNum != 0){
                int remainder = dicNum % 2;
                res[index] = remainder;
                dicNum = dicNum >> 1;
                index--;
            }
            cnt++;
        }
        return res;
    }
}
