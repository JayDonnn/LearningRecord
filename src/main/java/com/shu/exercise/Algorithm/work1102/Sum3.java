package Algorithm.work1102;

import java.util.*;

/**
 * 判断给定数组中是否存在三个元素它们的和为0，找出所有满足条件且不重复的三元组
 * leetcode15 https://leetcode-cn.com/problems/3sum/
 */
public class Sum3 {

    // 利用set，时间复杂度O(N^2)，空间复杂度O(N)
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -(nums[i] + nums[j]);
                if(set.contains(target)) {
                    resList.add(Arrays.asList(nums[i], nums[j], target));
                    while (j + 1 < nums.length - 1 && nums[j] == nums[j+1]) {
                        j++;
                    }
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return resList;
    }

    // 先排序结合双端指针，时间复杂度O(N^2)，空间复杂度O(1)
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int beginP = i + 1;
            int endP = nums.length - 1;
            while (beginP < endP) {
                int sum = nums[i] + nums[beginP] + nums[endP];
                if(sum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[beginP], nums[endP]));
                    while (beginP + 1 < endP && nums[beginP] == nums[beginP + 1]) {
                        beginP++;
                    }
                    while (endP - 1 > beginP && nums[endP] == nums[endP - 1]) {
                        endP--;
                    }
                    beginP++;
                    endP--;
                } else if(sum > 0) {
                    endP--;
                } else {
                    beginP++;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0, -1, -4};
        Sum3 sum3 = new Sum3();
//        List<List<Integer>> lists = sum3.threeSum1(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1,2,3));
        set.add(Arrays.asList(2,1,3));
        System.out.println();
    }
}
