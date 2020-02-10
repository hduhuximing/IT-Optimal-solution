package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 12:36 下午
 * @description 括号验证
 */
public class Parentheses {
    public static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '(' && c != ')') {
                return false;
            } else if (c == ')') {
                if (--left < 0) {
                    return false;
                }
            } else {
                left++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b=isValid("()()())");
        System.out.println(b);
    }

}
