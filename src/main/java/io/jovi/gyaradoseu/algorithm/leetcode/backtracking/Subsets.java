package io.jovi.gyaradoseu.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: 子集
 * </p>
 * <p>
 * Description:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
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
public class Subsets {
    /**
     * 子集
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backtrace(finalResult, result, nums, 0);
        return finalResult;
    }

    private static void backtrace(List<List<Integer>> finalResult, List<Integer> result, int[] nums, int i) {
        // 复制一个放入结果集 不然会保存指针 然后一直保存
        finalResult.add(new ArrayList<>(result));
        for (int p = i; p < nums.length; p++) {
            result.add(nums[p]);
            backtrace(finalResult, result, nums, p + 1);
            // 去除当前元素 计算下一个元素的结果集
            // 比如[1,2,3] 第一个访问1，通过回溯将1的结果集都汇总了 接下来就需要以2开头 计算结果集
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        List<List<Integer>> resultList = subsets(num1);
        System.out.println(resultList);
    }
}
