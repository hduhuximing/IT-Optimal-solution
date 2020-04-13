package com.mi.learn.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 12:52 下午
 * @description 最长可整合子数组长度
 */
public class maxLenArr {
    public int getLL1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (isintegraed(arr, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    private boolean isintegraed(int[] arr, int k, int j) {
        int[] curr = Arrays.copyOfRange(arr, k, j + 1);
        Arrays.sort(curr);
        for (int i = 0; i < curr.length - 1; i++) {
            if (curr[i] + 1 != curr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int getLL2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        int min = 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                if (max - min == j - i) {
                    res = Math.max(res, max - min + 1);
                }
            }
            set.clear();
        }
        return res;
    }
}
