package Algorithm.work1211;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 * leetcode300 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LIS {

    /**
     * 暴力法，即对于数组中的每个数都做（取/不取）两种选择，一直递归下去，知道取到数组最后一个元素，跳出递归
     * 时间复杂度O(N^2)   可以把递归过程想象成展开成一颗递归树，每个节点代表一次计算
     * 空间复杂度O(N)   往下递归N层，N=数组长度
     */
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        return lenSup(0, Integer.MIN_VALUE, nums);
    }

    private int lenSup(int curIndex, int prev, int[] nums) {
        if (curIndex == nums.length) {
            return 0;
        }
        int taken = 0;
        int notTaken = 0;
        if (prev < nums[curIndex]) {
            taken =  1 + lenSup(curIndex + 1, nums[curIndex], nums);
        }
        notTaken = lenSup(curIndex + 1, prev, nums);
        return taken > notTaken ? taken : notTaken;
    }

    // 方法二：DP
    public int lengthOfLIS1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;

        int ans = 0;
        for (int i = 1; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            ans = Math.max(temp, dp[i]);
        }

        return ans;
    }

    // 方法三：折半插入法    时间复杂度为O(nlogn), 空间复杂度O(n)
    // 维护一个上升子序列数组lis，因为有序所以可以使用折半插入
    // 具体的维护步骤是：从头开始遍历原数组一次，对每个遍历得到的元素i作判断，若大于lis数组的最后一个元素，就直接添加，如果不是就插入
    // 并替换lis中最小大于i的元素。遍历完成后，lis中包含的元素个数就是最长上升子序列
    public int lengthOfLIS2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] lis = new int[length];
        int rangeEndIndex = 0;
        for (int i:nums) {
            int site = Arrays.binarySearch(lis, 0, rangeEndIndex, i);
            if (site < 0) {
                site = -(site + 1);
            }
            lis[site] = i;
            if (site == rangeEndIndex) {
                rangeEndIndex++;
            }
        }
        return rangeEndIndex;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
        int[] nums = {1,2,3,1,2,4,5};
        System.out.println(lis.lengthOfLIS2(nums));
    }
}
