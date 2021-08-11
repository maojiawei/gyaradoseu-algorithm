package io.jovi.gyaradoseu.algorithm.leetcode.backtracking;

/**
 * <p>
 * Title: 单词搜索
 * </p>
 * <p>
 * Description:
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class Exist {
    /**
     * 单次搜索
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        // 先找到第一个元素
        char c1 = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == c1) {
                    boolean[][] result = new boolean[board.length][board[0].length];
                    result[i][j] = true;
                    if (backtrace(board, word, result, 1, i, j)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * 回溯
     *
     * @param board
     * @param word
     * @param p
     * @param i
     * @param j
     * @return
     */
    public static boolean backtrace(char[][] board, String word, boolean[][] result, int p, int i, int j) {
        // 找完了
        if (p >= word.length()) {
            return true;
        }

        // 上下左右四个方向
        // 上
        if (i > 0) {
            int a = i - 1, b = j;
            if (check(board,word,result,p,a,b)) {
                return true;
            }
        }
        // 下
        if (i < board.length - 1) {
            int a = i + 1, b = j;
            if (check(board,word,result,p,a,b)) {
                return true;
            }
        }
        // 左
        if (j > 0) {
            int a = i, b = j - 1;
            if (check(board,word,result,p,a,b)) {
                return true;
            }
        }
        // 右
        if (j < board[0].length - 1) {
            int a = i, b = j + 1;
            if (check(board,word,result,p,a,b)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证是否一致 如果一致 回溯
     *
     * @param board
     * @param result
     * @param p
     * @param a
     * @param b
     * @return
     */
    private static boolean check(char[][] board, String word, boolean[][] result, int p, int a, int b) {
        char c = word.charAt(p);
        char c1 = board[a][b];
        if (c == c1 && !result[a][b]) {
            result[a][b] = true;
            if (backtrace(board, word, result, p + 1, a, b)) {
                return true;
            } else {
                // 如果不存在 就重新置位false
                result[a][b] = false;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'a'}
        };
//        char[][] matrix = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
        String word = "aaa";
//        String word = "SEE";
        boolean exist = exist(matrix, word);
        System.out.println(exist);
    }

    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
    //"ABCESEEEFS"
}
