package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 11:35 上午
 * @description 每个字符的个数在当前的后面拼接
 */
public class Count {
    public static int getCountString(String str1) {
        if (str1 == null || str1.length() == 0) {
            return 0;
        }
        char[] chars = str1.toCharArray();
        StringBuilder str = new StringBuilder(chars[0]);
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            //找到切换点
            if (chars[i] != chars[i - 1]) {
                if (num > 1) {
                    str.append(num).append(chars[i]);
                } else {
                    str.append(chars[i]);
                }
                num = 1;
            } else {
                num++;
            }
        }
        if (num > 1) {
            str.append(num);
        }
        return str.length();
    }

    public static void main(String[] args) {
        int aabbccc = getCountString("aabbccc");
        System.out.println(aabbccc);
    }
}
