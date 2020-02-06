package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 5:48 下午
 * @description dnf
 */
public class dnf {
    public int minHp(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = m[row][col] > 1 ? 1 : -m[row][col] + 1;
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - m[row - 1][i]);
        }
        for (int j = row - 2; j >= 0; j--) {
            dp[j][col - 1] = Math.max(1, dp[j + 1][col - 1] - m[j][col - 1]);
        }
        int right=0;
        int down=0;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                right=Math.max(dp[i][j+1]-m[i][j],1);
                down=Math.max(dp[i+1][j]-m[i][j],1);
                //哪边需要的血少从哪边过来
                dp[i][j]=Math.min(right,down);
            }
        }
        return dp[0][0];
    }
}
