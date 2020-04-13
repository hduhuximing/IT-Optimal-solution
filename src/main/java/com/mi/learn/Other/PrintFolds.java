package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 11:27 上午
 * @description 折纸问题
 */
public class PrintFolds {
    public void print(int N) {
        help(1, N, true);
    }

    private void help(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        help(i+1,n,true);
        System.out.println(down?"down":"up");
        help(i+1,n,false);
    }

    public static void main(String[] args) {
        PrintFolds ps=new PrintFolds();
        ps.print(2);
    }
}
