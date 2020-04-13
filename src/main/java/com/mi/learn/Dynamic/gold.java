package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/4 3:02 下午
 * @description
 */
public class gold {
    public static void main(String[] args) {

        int w = 10;
        //人数
        int[] p = {5, 5, 3, 4, 3};
        //金子数
        int[] g = {400, 500, 200, 300, 350};
        int[][] dp = new int[g.length + 1][w + 1];
        //矿
        for (int i = 1; i <= g.length; i++) {
            //人数
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        System.out.println(dp[g.length][w]);
//        int[] dp = new int[w + 1];
//        for (int i = 1; i <= g.length; i++) {
//            //人数
//            for (int j = w; j >= 1; j--) {
//                if (j >= p[i - 1]) {
//                    dp[j] = Math.max(dp[j], dp[j - p[i - 1]] + g[i - 1]);
//                }
//            }
//        }
//        System.out.println(dp[w]);
    }
}