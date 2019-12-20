package Algorithm.work1014;

import java.util.*;

public class Main1 {
    static boolean CheckBlackList(String userIP, String blackIP) {
        if(blackIP.contains("/")){
            String subNet = blackIP.split("/")[0];
            int maskNetBits = Integer.parseInt(blackIP.split("/")[1]);

            int[] maskNet = new int[32];
            int[] ip1Arr = new int[32];
            int[] ip2Arr = new int[32];

            for (int i = 0; i < maskNetBits; i++) {
                maskNet[i] = 1;
            }

            ip1Arr = transfer(userIP);
            ip2Arr = transfer(subNet);

            return check(ip1Arr, ip2Arr, maskNet);
        } else {
            return userIP.equals(blackIP);
        }

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
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}

