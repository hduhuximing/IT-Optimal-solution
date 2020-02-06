package com.mi.learn.Dynamic;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 9:06 下午
 * @description 斐波那切数列
 */
public class Fibo {
    //1，1，2，3，5，8
    public int f1(int n){
        if(n<1){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return f1(n-1)+f1(n-2);
    }
}
