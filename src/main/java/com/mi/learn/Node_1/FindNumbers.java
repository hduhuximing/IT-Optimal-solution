package com.mi.learn.Node_1;

import java.util.ArrayList;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 7:18 下午
 * @description 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbers {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return list;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int cursum = array[i] + array[j];
            if (cursum == sum) {
                list.add(array[i]);
                list.add(array[j]);
            } else if (cursum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }
}
