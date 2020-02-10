package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 4:34 下午
 * @description 最小编辑代价
 */
public class MinPices {
    public int minCost(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i <= c1.length; i++) {
            dp[i][0] = dc * i;
        }
        for (int j = 0; j <= c2.length; j++) {
            dp[0][j] = ic * j;
        }
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                //删除和添加
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
