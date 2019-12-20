package Algorithm.work1206;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）
 * leetcode152 https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProductSubarray {

    /**
     * 方法一：分析，
     * 问题中的数组有四种情况，分别是1.全为正整数；2.只包含正整数和负整数且负整数的个数为偶数；3.负整数的个数为奇数；4.包含正整数、负整数、零
     * 情况1：所有元素的乘积就是所求结果；
     * 情况2：因为负负得正，因此可以看作是情况1
     * 情况3：可以看作用数组中的第一个（或最后一个）负数把数组分成三部分（情况1，负数本身，情况2）
     * 情况4：可以把数组中的零看作分界线，把数组分成若干个情况3的数组
     * 可以采用从前往后遍历和从后往前遍历两次求积来求得最大值（考虑 -1，-1，-1，-1，-2， 3这种情况，如果只进行一次从前往后遍历求得的积为1），
     * 同时在遍历的过程中，遇到零就把max置为1（相当于开始一个新的数组遍历，因为只要包含了0，则积就一直为0）
     * 时间复杂度O(N),空间复杂度O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max *= nums[i];
            res = Integer.max(res, max);
            if (nums[i] == 0) {
                max = 1;
            }
        }
        max = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            max *= nums[i];
            res = Integer.max(res, max);
            if (nums[i] == 0) {
                max = 1;
            }
        }

        return res;
    }


    /**
     * 方法二：动态规划
     *
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];

        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] < 0) {
                max[i] = Integer.max(min[i-1] * nums[i], nums[i]);
                min[i] = Integer.min(max[i-1] * nums[i], nums[i]);
            } else {
                max[i] = Integer.max(max[i-1] * nums[i], nums[i]);
                min[i] = Integer.min(min[i-1] * nums[i], nums[i]);
            }
            res = res > max[i] ? res : max[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        int[] nums1 = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};
        int res = maxProductSubarray.maxProduct1(nums1);
        System.out.println(res);
    }
}
