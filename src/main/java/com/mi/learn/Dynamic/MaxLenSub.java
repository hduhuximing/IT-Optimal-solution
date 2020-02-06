package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 3:59 下午
 * @description 最长公共子串问题
 */
public class MaxLenSub {
    public int[][] getdp(char[] s1, char[] s2) {
        int[][] dp = new int[s1.length][s2.length];
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == s2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < s2.length; j++) {
            if (s2[j] == s1[0]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public String maxLen(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = getdp(c1, c2);
        int max = 0;
        int end = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        MaxLenSub maxLenSub = new MaxLenSub();
        String s = maxLenSub.maxLen("abcde", "bebcd");
        System.out.println(s);
    }
}
