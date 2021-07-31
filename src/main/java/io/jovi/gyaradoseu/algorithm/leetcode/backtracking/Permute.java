package io.jovi.gyaradoseu.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Title: 全排列
 * </p>
 * <p>
 * Description:
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class Permute {
    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> numsList = new ArrayList();
        for (int e : nums) numsList.add(e);
        backtrace(result, numsList, 0);
        return result;
    }

    /**
     * @param result
     * @param nums
     * @param li
     * @return
     */
    private static void backtrace(List<List<Integer>> result, List<Integer> nums, int li) {
        if (li == nums.size() - 1) result.add(new ArrayList(nums));
        for (int i = li; i < nums.size(); ++i) {
            Collections.swap(nums, li, i);
            backtrace(result, nums, li + 1);
            Collections.swap(nums, i, li);
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        List<List<Integer>> resultList = permute(num1);
        System.out.println(resultList);
    }
}
