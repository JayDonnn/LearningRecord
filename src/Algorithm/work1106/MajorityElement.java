package Algorithm.work1106;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * leetcode169 https://leetcode-cn.com/problems/majority-element/
 * 较好的解法包括：1.排序法；2.hashmap法；3.分治法；4.Boyer-Moore投票法
 */
public class MajorityElement {

    /**
     * Boyer-Moore投票法
     * 因为题目规定，众数的个数大于n/2，我们可以用+1表示众数，-1表示其他的数
     * 所有所有的+1，-1相加的和一定是大于1的
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int cnt = 0;
        for (int num:nums) {
            if(cnt == 0) {
                candidate = num;
            }
            cnt += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
