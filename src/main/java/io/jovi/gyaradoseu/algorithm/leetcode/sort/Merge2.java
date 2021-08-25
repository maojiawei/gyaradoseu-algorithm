package io.jovi.gyaradoseu.algorithm.leetcode.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * Title: 合并区间
 * </p>
 * <p>
 * Description:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
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
public class Merge2 {
    public static int[][] merge(int[][] intervals) {

        // 先进行排序 首位从大到小排列
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int p = intervals[i][0];
                    intervals[i][0] = intervals[j][0];
                    intervals[j][0] = p;
                    int q = intervals[i][1];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][1] = q;
                }
            }
        }
        // 保存结果集 用key代表起始 value代表终止
        Map<Integer, Integer> result = new LinkedHashMap<>(intervals.length);
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果区间重合
            if (max >= intervals[i][0]) {
                max = Math.max(intervals[i][1], max);
                continue;
            }
            // 如果无法重合保存结果集
            result.put(min, max);
            min = intervals[i][0];
            max = intervals[i][1];
        }
        // 最后一位还需要加回来 不然就漏了
        result.put(min, max);
        System.out.println(result);
        int[][] matrix = new int[result.keySet().size()][2];
        int k = 0;
        for (Integer key : result.keySet()) {
            matrix[k][0] = key;
            matrix[k][1] = result.get(key);
            k++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {8, 10},
                {1, 3},
                {15, 18},
                {2, 6}
        };
        int[][] a = merge(matrix);
        System.out.println(a);
    }
}
