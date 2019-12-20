package Algorithm.work1209;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * leetcode 213 https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII {

    // 因为首尾相连，所以可以将数组分成两种情况 1.取头不取尾；2.取尾不取头；
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res1 = robSup(0, nums.length - 1, nums);
        int res2 = robSup(1, nums.length, nums);
        return res1 > res2 ? res1 : res2;
    }

    private int robSup(int start, int end, int[] nums) {
        int prevValue_1 = 0;
        int prevValue_2 = 0;
        for (int i = start; i < end; i++) {
            int temp = prevValue_1;
            prevValue_1 = Integer.max(prevValue_1, prevValue_2 + nums[i]);
            prevValue_2 = temp;
        }
        return prevValue_1;
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int[] nums = {1,3,1,3,100};
        int res = houseRobberII.rob(nums);
        System.out.println(res);
    }
}
