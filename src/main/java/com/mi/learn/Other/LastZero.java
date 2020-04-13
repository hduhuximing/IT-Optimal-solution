package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 10:06 上午
 * @description n!末尾0的数量
 */
public class LastZero {
    //2的数量一定是大于5的数量
    public static int zeroNum(int num) {
        if (num < 0) {
            return 0;
        }
        int count = 0;
        while (num != 0) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }
    public static void main(String[] args) {
        int i = zeroNum(10);
        System.out.println(i);
    }
}
