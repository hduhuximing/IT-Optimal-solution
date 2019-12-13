package com.mi.learn.Stack_1;

import java.util.LinkedList;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/13 2:45 下午
 */
public class Stack7 {
    public int[] getMaxWindows(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w < 1) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        //res 的位置
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.offer(arr[i]);

            if (list.peekFirst() == arr.length - w) {
                list.pollFirst();
            }

            if (i - w + 1 >= 0) {
                res[index++] = arr[list.peekLast()];
            }
        }
        return res;
    }
}
