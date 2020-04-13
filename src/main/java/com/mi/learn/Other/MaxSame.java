package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 9:40 上午
 * @description 最大公约数
 */
public class MaxSame {
    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
