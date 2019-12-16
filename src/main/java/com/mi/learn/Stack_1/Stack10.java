package com.mi.learn.Stack_1;

import java.util.LinkedList;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/16 8:20 下午
 */
public class Stack10 {
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && qmin.peekLast() >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && qmax.peekLast() <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //跳出，找到当前不符合的位置，右侧走到跳出位
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                //否则继续循环
                j++;
            }
            //这里要删除两个列表中头结点为i的元素
            /**
             * 解释一下这里，由于i为最左边元素，因此一定是最先进入两个队列的，后续如果他仍然存在必然是在头位置，不可能在后面。
             * 当我们循环了一遍后此时需要向右滑动，因此最左边的数据需要清除，那么只需要判断当前的头数据即可
             */
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            //从左边i开始都是符合的 i~j-1，i~j-2。。。。。i~i
            res += j - i;
            i++;
        }
        return res;
    }
}
