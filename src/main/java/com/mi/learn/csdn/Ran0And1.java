package com.mi.learn.csdn;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/2 2:43 下午
 * @description 给一个函数，返回 0 和 1，概率为 p 和 1-p，请你实现一个函数，使得返回 0 1 概率一样
 */
public class Ran0And1 {
    public void rand() {
        int i = Math.random() > 0.7 ? 1 : 0;
        int j = Math.random() > 0.7 ? 1 : 0;
        int res;
        while (true) {
            if (i == 0 && j == 1) {
                res = 0;
                break;
            } else if (i == 1 && j == 0) {
                res = 1;
                break;
            } else {
                continue;
            }
        }
        System.out.println(res);
    }


}
