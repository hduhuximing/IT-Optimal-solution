package com.mi.learn.Array;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 1:52 下午
 * @description 未排序正数数组中累加和为给定值的z最长子串长度
 */
public class MaxlenSumT {
    public static int getLen(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int max = 0;
        while (right < arr.length) {
            if (sum < target) {
                if (++right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else if (sum > target) {
                sum -= arr[left++];
            } else {
                max = Math.max(max, right - left + 1);
                sum -= arr[left++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int len = getLen(new int[]{1, 3, 1, 1, 1}, 3);
        System.out.println(len);
    }
}
