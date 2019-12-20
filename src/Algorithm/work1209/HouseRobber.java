package Algorithm.work1209;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
 * 就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * leetcode198 https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {

    // 方法一回溯法
    // 时间复杂度O(2^N)  超时  空间复杂度O(N)
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        return Integer.max(robSup(0, true, nums), robSup(1, true, nums));
    }

    private int robSup(int target, boolean isRob, int[] nums) {
        if (target >= nums.length) {
            return 0;
        }
        if (isRob) {
            return nums[target] + Integer.max(robSup(target + 2, true, nums), robSup(target + 2, false, nums));
        } else {
            return Integer.max(robSup(target + 1, true, nums), robSup(target + 1, false, nums));
        }
    }


    // 常规DP法   时间复杂度O(N)   空间复杂度O(N)
    public int rob1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int money = Integer.max(nums[i-1] + dp[i-2], dp[i-1]);
            dp[i] = money;
        }
        return dp[nums.length];
    }

    // 空间复杂度为O(1)的DP法
    // 因为DT方程为 maxMoney = Max(houseValue + prevValue_2, prevValue_1),
    // 因此只需要动态记录前隔两间房的抢劫所得最大值和前隔一间房的抢劫所得最大值
    public int rob2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int prevValue_1 = 0;
        int prevValue_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = prevValue_1;
            prevValue_1 = Integer.max(nums[i] + prevValue_2, prevValue_1);
            prevValue_2 = temp;
        }
        return prevValue_1;
    }


    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {3,1,3,100};
        int res  = houseRobber.rob2(nums);
        System.out.println(res);
    }
}
