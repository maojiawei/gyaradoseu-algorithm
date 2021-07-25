package io.jovi.gyaradoseu.algorithm.leetcode.backtracking;


import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Title: 括号生成
 * </p>
 * <p>
 * Description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class GenerateParenthesis {
    /**
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list  = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }

    /**
     * 回溯算法
     * 题目限制：1. "（"要先于")" 2. "（"个数和")"个数相同
     * 看一下结果集，第一个肯定是"（"，第二个字母可能是"("，也可能是")"，依次类推。
     * @param str 计算至当前结果
     * @param list 结果集
     * @param left 左括号
     * @param right 右括号
     * @param n 总的个数
     */
    public static void backtrack(List<String> list, String str, int left ,int right, int n) {
        // 如果没有结束
        if(str.length() == (n * 2)){
            list.add(str);
        } else {
            // 只有当左括号 大于有括号时 才会同时增加 左右括号
            if(left > right){
                // 防止出现过多左括号
                if(left < n){
                    backtrack(list,str+"(",left+1,right,n);
                }

                backtrack(list,str+")",left,right+1,n);
            } else {
                backtrack(list,str+"(",left+1,right,n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }
}
