package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 12:20 下午
 * @description 12**456-》**12345
 */
public class MoveToFirst {
    public static char[]  move(char[] chas) {
        if (chas == null || chas.length == 0) {
            return null;
        }
        int index = chas.length - 1;
        for (int i = chas.length - 1; i >= 0; i--) {
            if (chas[i] != '*') {
                chas[index--] = chas[i];
            }
        }
        for(;index>=0;index--){
            chas[index]='*';
        }
        return chas;
    }

    public static void main(String[] args) {
        String s="12**456";
        char[] move = move(s.toCharArray());
        System.out.println(move);
    }
}
