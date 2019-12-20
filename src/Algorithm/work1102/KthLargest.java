package Algorithm.work1102;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（leetcode703）
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */

public class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);
        } else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
