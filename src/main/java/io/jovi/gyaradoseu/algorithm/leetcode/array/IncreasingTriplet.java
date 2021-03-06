package io.jovi.gyaradoseu.algorithm.leetcode.array;

/**
 * <p>
 * Title: 递增的三元子序列
 * </p>
 * <p>
 * Description:
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IncreasingTriplet {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,5,5,2,5,4};
        boolean flag = increasingTriplet(nums);
        System.out.println(flag);

    }

    /**
     * 递增的三元子序列
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        if(nums.length < 3){
            return false;
        }
        for(int num:nums){
            if(first>num){
                first = num;
            }else if(first<num && second>num){
                second = num;
            }else if(num>second){
                return true;
            }
        }
        return false;
    }
}
