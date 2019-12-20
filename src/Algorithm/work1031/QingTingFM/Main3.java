package Algorithm.work1031.QingTingFM;

/**
 * 蜻蜓FM 笔试题
 * 在一个有序数组中找出某个数
 */

public class Main3 {

    public int findKIndex(int[] arr, int k) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if(arr[mid] == k) {
                return mid;
            } else if(arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,5};
        int k1 = 1;
        int k2 = 5;
        Main3 main3 = new Main3();
        System.out.println(main3.findKIndex(arr, k1));
        System.out.println(main3.findKIndex(arr, k2));
    }
}
