package Algorithm.work1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DriftBoat {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = bufferedReader.readLine().split(" ");
        int[] people_weights = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            people_weights[i] = Integer.parseInt(splits[i]);
        }
        int limit = Integer.parseInt(bufferedReader.readLine());
        int res = needMinBoats(people_weights, limit);
        System.out.println(res);
    }

    private static int needMinBoats(int[] people_weights, int limit) {
        Arrays.sort(people_weights);
        int i = 0, j = people_weights.length - 1;
        int cnt = 0;
        while (j >= 0){
            if(people_weights[j] == limit){
                cnt++;
                j--;
            } else {
                break;
            }
        }
        while (i <= j){
            if(people_weights[i] + people_weights[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            cnt++;
        }
        return cnt;
    }
}
