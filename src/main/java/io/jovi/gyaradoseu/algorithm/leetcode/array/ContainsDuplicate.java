package io.jovi.gyaradoseu.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Title: 存在重复
 * </p>
 * <p>
 * Description:
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-02-11.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ContainsDuplicate {
    /**
     * 存在重复
     * 解题思路:
     * 1. 建立一个set集合(set集合不存在重复数据)
     * 2. 依次遍历数组，如果存在set集合存在，则说明存在重复；如果不存在，将值塞入set集合中，以便于下次查询。
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i:nums){
            if(numSet.contains(i)){
                flag = true;
            }
            numSet.add(i);
        }
        return flag;
    }

    /**
     * 存在重复
     * 解题思路:
     * 1. 判断数组长度，如果数组长度只有1 不会存在重复
     * 2. 对数组按照从小到大排序
     * 3. 判断相邻是否重复，如果存在重复，则为true。
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        // 如果数组长度只有1 不会存在重复
        if(nums.length < 2){
            return false;
        }
        //先对数组进行排序，再判断相邻是否有重复的
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        boolean flag = containsDuplicate(nums);
        System.out.println(flag);
    }
}
