package com.mi.learn.String;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 11:49 上午
 * @description 在有序并且含有空位置的数组中查找字符串第一个出现的位置
 */
public class FindString {
    public static int getString(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }
        int res = -1;
        int i = 0;
        int j = strs.length - 1;
        int mid = -1;
        int cur = -1;
        while (i <= j) {
            mid = (j - i) / 2 + i;
            //先处理非空，后处理空
            if (strs[mid] != null && str.equals(strs[mid])) {
                res = mid;
                j = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                cur = mid;
                //左半区，如果都是空的或者存在一个数，但是小于当前的目标值。表示作半边都可以舍去
                while (strs[cur] == null && --cur >= i) ;
                if (cur < i || strs[cur].compareTo(str) < 0) {
                    i = mid + 1;
                } else {
                    res = strs[cur].compareTo(str) == 0 ? cur : res;
                    j = i - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={null,"a",null,"a",null,"b",null,"b"};
        int a = getString(strs, "b");
        System.out.println(a);
    }
}
