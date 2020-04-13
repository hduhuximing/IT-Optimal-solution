package com.mi.learn.Array;

import java.util.concurrent.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 7:56 下午
 * @description 找到需要排序的最短子数组的长度
 */
public class MinLen {
    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int minIndex = -1;
        int max = arr[0];
        int maxIndex = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > min) {
                minIndex = i;
            } else {
                min = arr[i];
            }
        }
        if (min == -1) {
            return 0;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <max){
                maxIndex=i;
            }else{
                max=arr[i];
            }
        }
        return maxIndex-minIndex+1;
    }

    public static void main(String[] args) {
        int[] i={1,5,3,4,2,6,7};
        int minLength = getMinLength(i);
        System.out.println(minLength);
    }
}
