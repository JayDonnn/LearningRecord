package Algorithm.work1024;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,5};
        System.out.println(format(arr));
    }

    public static int format(int[] arr){
        int i = 0, j = arr.length - 1;
        while (i <= j){
            while (arr[i] % 2 == 1) i++;
            while (arr[j] % 2 == 0) j--;
            if(i <= j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
}
