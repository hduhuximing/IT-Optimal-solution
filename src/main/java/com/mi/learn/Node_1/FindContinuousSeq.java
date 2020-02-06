package com.mi.learn.Node_1;

import java.util.ArrayList;
/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 7:00 下午
 * @description https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class FindContinuousSeq {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }
        //滑动窗口
        int small = 1;
        int big = 2;
        int cursum = small + big;
        int mid = (sum + 1) / 2;
        while (small < mid) {
            if (cursum == sum) {
                add(res, small, big);
            }
            //够了怎么处理,循环遍历直到小于sum，其中可能会出现等于的情况
            while (cursum > sum && small < mid) {
                cursum -= small;
                small++;
                if (cursum == sum) {
                    add(res, small, big);
                }
            }
            //不够就添加
            big++;
            cursum += big;
        }
        return res;
    }

    private void add(ArrayList<ArrayList<Integer>> res, int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        res.add(list);
    }
}
