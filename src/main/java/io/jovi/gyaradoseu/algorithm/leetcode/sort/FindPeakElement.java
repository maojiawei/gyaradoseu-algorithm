package io.jovi.gyaradoseu.algorithm.leetcode.sort;

/**
 * <p>
 * Title: 寻找峰值
 * </p>
 * <p>
 * Description:
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *  
 *
 * 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class FindPeakElement {
    /**
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        for(int i = 1; i <= nums.length - 1; i++){
            if(nums[i] > nums[i-1] ) {
                //&& nums[i] > nums[i+1]
                // 防止outofbound异常
                if (i == nums.length - 1){
                    return i;
                }
                if(nums[i] > nums[i+1]){
                    return i;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1};
        int k = findPeakElement(num1);
        System.out.println(k);
    }


}
