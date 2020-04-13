package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 11:46 上午
 * @description 从N个数中等概率打印M个数
 */
public class PrintMFromN {
    public void printRandM(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int min = Math.min(m, arr.length);
        int index = 0;
        int count = 0;
        for (int i = 1; i <= min; i++) {
            index = (int) (Math.random() * (arr.length - count));
            System.out.println(arr[index]);
            swap(arr, index, arr.length - ++count);
        }
    }

    private void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }
}
