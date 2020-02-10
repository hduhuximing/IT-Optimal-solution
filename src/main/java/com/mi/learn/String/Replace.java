package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 10:54 上午
 * @description 替换字符串中连续出现的指定字符,用零替换
 */
public class Replace {
    public static String replace1(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals("")) {
            return null;
        }
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        //将位置替换为0
        for (int i = 0; i < str.length(); i++) {
            if (chas[i] == chaf[match++]) {
                if (match == from.length()) {
                    //替换
                    clear(chas, i, from.length());
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (chas[j] != 0) {
                cur.append(chas[j]);
            } else if (chas[j] == 0 && (j == 0 || chas[j - 1] != 0)) {
                res.append(cur).append(to);
                cur = new StringBuilder();
            }
        }
        res.append(cur);
        return res.toString();

    }

    private static void clear(char[] chas, int i, int length) {
        while (length-- != 0) {
            chas[i--] = 0;
        }
    }

    public static void main(String[] args) {
        String abc = replace1("123abcabc", "abc", "4567");
        System.out.println(abc);
    }
}
