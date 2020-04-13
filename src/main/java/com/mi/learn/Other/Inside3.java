package com.mi.learn.Other;

import java.math.BigDecimal;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 10:55 上午
 * @description 判断一个点是不是在三角形内部
 */
public class Inside3 {
    //求长度
    public double getlen(double x1, double y1, double x2, double y2) {
        double x = Math.abs(x1 - x2);
        double y = Math.abs(y1 - y2);
        return Math.sqrt(x * x + y * y);
    }

    //求面积
    public double getArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double len1 = getlen(x1, y1, x2, y2);
        double len2 = getlen(x1, y1, x3, y3);
        double len3 = getlen(x2, y2, x3, y3);
        double ss = (len1 + len2 + len3) / 2;
        return Math.sqrt(ss * (ss - len1) * (ss - len2) * (ss - len3));
    }

    //三个小面积应该小于等于最大的面积
    public boolean isInside(double x1, double y1, double x2, double y2, double x3, double y3, double x, double y) {
        double area1 = getArea(x1, y1, x2, y2, x, y);
        double area2 = getArea(x1, y1, x3, y3, x, y);
        double area3 = getArea(x3, y3, x2, y2, x, y);
        double area4 = getArea(x1, y1, x2, y2, x3, y3);
        return area1 + area2 + area3 <= area4;
    }

}
