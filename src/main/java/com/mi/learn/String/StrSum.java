package com.mi.learn.String;


/**
 * @author ming
 * @version 1.0
 * @date 2020/2/7 9:17 下午
 * @description 字符串中数字子串求和
 */
public class StrSum {
    public static int NumSum(String str) {
        if (str == null) {
            return 0;
        }
        int res = 0;
        boolean pos = true;
        //拼接的数据
        int num = 0;
        //当前标识
        int cur = 0;
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                //todo 添加并判断
                res += num;
                num = 0;
                if (cur == '-') {
                    if (i > 0 & charArr[i - 1] == '-') {
                        pos = !pos;
                    }
                } else {
                    pos = true;
                }
            } else {
                //todo 拼接num
                num = num * 10 + (pos ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        int i = NumSum("A-1BCD--21DD8");
        System.out.println(i);
    }
}
