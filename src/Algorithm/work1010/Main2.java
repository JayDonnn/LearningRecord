package Algorithm.work1010;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String ip1 = sc.next();
            String ip2 = sc.next();
            String mask = sc.next();
            if(Integer.valueOf(mask) == 24){
                mask = "11111111.11111111.11111111.00000000";
            }

        }
    }

    private static void isSubNet(String[] inputs) {
        if(inputs == null || inputs.length != 3)
            return;
        String addr1 = inputs[0];
        String addr2 = inputs[1];
        String maskNetLength = inputs[2];


    }

    private static int[] transfer(String ip){
        String[] ipstr = ip.split("\\.");
        int len = ipstr.length;
        int[] ip_int = new int[len];
        for (int i = 0; i < len; i++) {
            ip_int[i] = 0;
        }
        for (int i = 0; i < len; i++) {
            ip_int[i] = Integer.parseInt(ipstr[i]);
        }
        return ip_int;
    }

    private static boolean checkIp(int[] ip_int){
        if(ip_int.length != 4) return false;
        if(ip_int[0] == 172 || ip_int[0] == 0 ||ip_int[0] >= 255)
            return false;
        for (int i = 1; i < 4; i++) {
            if(ip_int[i] > 255)
                return false;
        }
        return true;
    }

    private static boolean checkSubNet(String mask, String ip1, String ip2){
        int[] ip1_int = transfer(ip1);
        int[] ip2_int = transfer(ip2);
        int[] mask_int = transfer(mask);
        int len = mask_int.length;
        for (int i = 0; i < len; i++) {
            if((ip1_int[i] & mask_int[i]) != (ip2_int[i] & mask_int[i]))
                return false;
        }
        return true;
    }

    private static String check(int length){
        int mask = -1 << (32 - length);
        int partsNum = 4;
        int bitsOfPart = 8;
        int maskParts[] = new int[partsNum];
        int selector = 0x000000ff;
        for (int i = 0; i < maskParts.length; i++) {
            int pos = maskParts.length - 1 - i;
        }
        String result = "";
        result = result + maskParts[0];
        for (int i = 1; i < maskParts.length; i++) {
            result = result + "." + maskParts[i];
        }
        return result;
    }
}
