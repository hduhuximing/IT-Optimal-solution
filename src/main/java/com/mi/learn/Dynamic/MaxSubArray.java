package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/5 1:28 下午
 * @description 最长上升子串，不按顺序
 */
public class MaxSubArray {
    public static int[] getdp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    //    public static
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] dp = getdp(arr);
    }
}
