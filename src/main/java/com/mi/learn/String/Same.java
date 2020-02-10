package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/7 6:11 下午
 * @description 变形词
 */
public class Same {
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            map[c1[i]]++;
        }
        for (int j = 0; j < str2.length(); j++) {
            if (map[c2[j]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDeformation("123", "312"));
        System.out.println(isDeformation("abcde","abced"));
    }
}
