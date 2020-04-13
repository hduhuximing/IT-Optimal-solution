package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 9:36 上午
 * @description
 */
public class FiveToSeven {
    private int randto5() {
        return (int) (Math.random() - 1) * 5;
    }

    private int rand7() {
        int num = 0;
        do {
            num = 5 * (randto5() - 1) + (randto5() - 1);
        } while (num > 20);//3*7
        return num % 7 + 1;
    }
}
