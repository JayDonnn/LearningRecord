package Algorithm.work1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        mostSeq(inputs[0].toCharArray(), inputs[1].toCharArray());
    }

    private static void mostSeq(char[] str1, char[]str2) {
        int len1, len2;
        len1 = str1.length;
        len2 = str2.length;

        int maxLength = len1 > len2 ? len1 : len2;

        int[] max = new int[maxLength];
        int[] maxIndex = new int[maxLength];
        int[] c = new int[maxLength];

        for (int i = 0; i < len2; i++) {
            for (int j = len1 - 1; j >= 0; j--) {
                if(str2[i] == str1[j]){
                    if((i == 0) || (j == 0)){
                        c[j] = 1;
                    } else {
                        c[j] = c[j - 1] + 1;
                    }
                } else {
                    c[j] = 0;
                }

                if(c[j] > max[0]){
                    max[0] = c[j];
                    maxIndex[0] = j;
                    for (int k = 1; k < maxLength; k++) {
                        max[k] = 0;
                        maxIndex[k] = 0;
                    }
                } else if(c[j] == max[0]){
                    for (int k = 1; k < maxLength; k++) {
                        if(max[k] == 0){
                            max[k] = c[j];
                            maxIndex[k] = j;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < maxLength; i++) {
            if(max[i] > 0){
                for (int j = maxIndex[i] - max[i] + 1; j <= maxIndex[i]; j++) {
                    System.out.print(str1[j]);
                }
                System.out.println(" ");
            }
        }



    }
}
