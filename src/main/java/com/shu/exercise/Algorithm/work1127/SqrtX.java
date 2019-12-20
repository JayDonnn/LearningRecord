package Algorithm.work1127;

/**
 * 实现 int sqrt(int x) 函数,计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * leetcode69 https://leetcode-cn.com/problems/sqrtx/
 */
public class SqrtX {

    // 方法1：二分法
    // 思路：y=x^2这个函数是单调递增的，即该函数描述的数据是有序的
    // 所以解这个题可以用二分法，令y为上界，根据题目要求可以知道0为下界
    // 利用二分的思想不断逼近那个x
    public int mySqrt(int x) {
        long start = 0;
        long end = x / 2 + 1;   // 一个数开根号一定小于其一半，加一是为了兼容x=0，1，2，3，4的情况
        while (start < end) {
            long mid = (start + end + 1) >> 1;   // 取右中位数
            if(x < mid * mid) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return (int)start;
    }

    // 牛顿法
    public int mySqrt1(int x) {
        return 0;
    }

    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(5));
    }

}
