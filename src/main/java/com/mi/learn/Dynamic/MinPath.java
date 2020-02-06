package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 10:26 上午
 * @description 矩阵从左上角只能向下或者向右走到右下角
 */
public class MinPath {
    public int getMinPath(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = m[0][0];
        int row = m.length;
        int col = m[0].length;
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
