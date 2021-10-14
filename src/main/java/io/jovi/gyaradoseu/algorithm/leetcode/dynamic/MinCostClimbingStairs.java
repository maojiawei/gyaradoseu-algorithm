package io.jovi.gyaradoseu.algorithm.leetcode.dynamic;

/**
 * <p>
 * Title: 使用最小花费爬楼梯
 * </p>
 * <p>
 * Description:
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为[0, 999] 。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class MinCostClimbingStairs {
    /**
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        //楼梯数组的长度
        int len = cost.length;
        //+3是因为前两个记录第一层楼梯的前面两个的爬楼梯花费（都为0），最后一个是与最后登顶的最后一个
        int[] dp = new int[len + 3];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = cost[i - 2] + Math.min(dp[i - 1], dp[i - 2]);
        }
        //对于登顶的处理，等于dp最后一个元素的前面两个数组中最小的一个在加上登顶花费0；
        dp[dp.length - 1] = Math.min(dp[dp.length - 3], dp[dp.length - 2]) + 0;

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 15, 20};
        int cost = minCostClimbingStairs(nums);
        System.out.println(cost);
    }
}
