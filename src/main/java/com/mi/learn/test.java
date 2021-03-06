package com.mi.learn;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/6 5:58 下午
 * @description
 */
public class test {
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }
        ArrayList<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 2;
        int mid = target / 2;
        int cursum = i + j;
        while (i <= mid) {
            if (cursum == target) {
                add(res, i, j);
            }
            while (i < j && cursum > target) {
                cursum -= i++;
                if (cursum == target) {
                    add(res, i, j);
                }
            }
            cursum += ++j;
        }
        return res.toArray(new int[0][]);
    }

    public void add(ArrayList<int[]> list, int i, int j) {
        int[] res = new int[j - i + 1];
        int len = j - i + 1;
        for (int index = 0; index < len; index++) {
            res[index] = i++;
        }
        list.add(res);
    }

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
        //在常量池中生成的是两个没拼接的，在堆中生成一个。
        String s2 = new String("Progra") + new String("mming");
        s2.intern();
        String s1 = "Programming";
        System.out.println(s2 == s1);
//        String s3 = "Program";
//        String s4 = "ming";
//        String s5 = "Program" + "ming";
//        String s6 = s3 + s4;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s6.intern());
//        System.out.println(s2 == s2.intern());
    }
}
