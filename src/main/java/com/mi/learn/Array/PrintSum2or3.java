package com.mi.learn.Array;

import static sun.misc.Version.print;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 1:13 下午
 * @description 不重复打印数组中和为给定数的所有二元 三元组
 */
public class PrintSum2or3 {
    //单独的二元求解,排序好的，有重复的
    public static void print2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int curr = arr[i] + arr[j];
            if (curr > k) {
                j--;
            } else if (curr < k) {
                i++;
            } else {
                //去重
                if (i == 0 || arr[i] != arr[i - 1]) {
                    System.out.println(arr[i] + "---" + arr[j]);
                }
                i++;
                j--;
            }
        }
    }

    public static void print3(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i <= arr.length - 3; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                print(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    private static void print(int[] arr, int prei, int i, int j, int target) {
        while (i < j) {
            int curr = arr[i] + arr[j];
            if (curr > target) {
                j--;
            } else if (curr < target) {
                i++;
            } else {
                if (prei + 1 == i || arr[i] != arr[i - 1]) {
                    System.out.println(arr[prei] + "-----" + arr[i] + "------" + arr[j]);
                }
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        print2(new int[]{1, 2, 3, 4, 4, 5, 5, 6, 7}, 9);
        print3(new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 9, 10}, 13);
    }
}
