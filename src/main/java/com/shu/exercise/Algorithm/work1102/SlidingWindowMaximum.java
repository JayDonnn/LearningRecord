package Algorithm.work1102;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用一个大小为K的窗口，在数组nums上从左向右滑动，每次滑动一格，求每次窗口中的最大值
 * leetcode239 https://leetcode-cn.com/problems/sliding-window-maximum/
 */

public class SlidingWindowMaximum {

    /**
     * 双端队列的方法
     * @param nums
     * @param k
     * @return
     */
    private Deque<Integer> deque = new ArrayDeque<>();
    private int[] nums;
    private int k;

    private void cleanDeque(int i) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length * k <= 0) {
            return new int[0];
        }
        if (nums.length == 1) {
            return nums;
        }
        // initial
        int length = nums.length;
        int[] res = new int[length - k + 1];
        this.nums = nums;
        this.k = k;
        for (int i = 0; i < k; i++) {
            cleanDeque(i);
            deque.addLast(i);
        }
        res[0] = nums[deque.getFirst()];
        for (int i = k; i < length; i++) {
            cleanDeque(i);
            deque.addLast(i);
            res[i - k + 1] = nums[deque.getFirst()];
        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        return null;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] testData = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = s.maxSlidingWindow1(testData, 3);
        for (int elem : res) {
            System.out.println(elem);
        }
    }


}
