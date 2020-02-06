package com.mi.learn;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/6 5:58 下午
 * @description
 */
public class test {
    public static void main(String[] args) {
        String s = "黑马";
        try {
            byte[] gbks = s.getBytes("GBK");
            String s1 = new String(gbks, "UTF-8");
            System.out.println(Arrays.toString(s1.getBytes()));
            String s2 = new String(gbks, "gbk");
            System.out.println(s2);
            System.out.println(s1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
