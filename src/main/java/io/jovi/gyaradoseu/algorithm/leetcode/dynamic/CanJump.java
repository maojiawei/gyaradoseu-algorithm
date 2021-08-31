package io.jovi.gyaradoseu.algorithm.leetcode.dynamic;

/**
 * <p>
 * Title: 跳跃游戏
 * </p>
 * <p>
 * Description:
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 *
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        // 你最初位于数组的第一个下标
        int mostFar = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            // 如果i < mostFar 则意味着位置i 可以到达，必须要先到达i 才去根据nums[i] 更新mostFar，
            // 否则遇到[1,0,1,0] 这种case 会导致求解出错
            if (i <= mostFar) {
                mostFar = Math.max(mostFar, i + nums[i]);
            }
        }
        return mostFar >= nums.length - 1;
    }

}
