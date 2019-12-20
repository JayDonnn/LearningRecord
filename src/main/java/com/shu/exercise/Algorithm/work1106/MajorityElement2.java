package Algorithm.work1106;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。(要求时间复杂度为O(N),空间复杂度为O(1))
 * leetcode229  https://leetcode-cn.com/problems/majority-element-ii/
 */
public class MajorityElement2 {

    /**
     * 投票法
     * 注意：因为投票法的结果无法保证元素的出现次数超过n/3，所以要再遍历一遍数组
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums == null || nums.length <= 0) {
            return res;
        }
        int candidateA = nums[0], candidateB = nums[0];
        int voteA = 0, voteB = 0;
        for (int num:nums) {
            if(num == candidateA) {
                voteA++;
                continue;
            }
            if(num == candidateB) {
                voteB++;
                continue;
            }
            if(voteA == 0) {
                candidateA = num;
                voteA = 1;
                continue;
            }
            if(voteB == 0) {
                candidateB = num;
                voteB = 1;
                continue;
            }
            voteA--;
            voteB--;
        }

        voteA = 0;
        voteB = 0;
        for (int num:nums) {
            if(num == candidateA) {
                voteA++;
            } else if(num == candidateB) {
                voteB++;
            }
        }
        if(voteA > nums.length / 3) {
            res.add(candidateA);
        }
        if(voteB > nums.length / 3) {
            res.add(candidateB);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        MajorityElement2 majorityElement2 = new MajorityElement2();
        majorityElement2.majorityElement(nums);
    }
}
