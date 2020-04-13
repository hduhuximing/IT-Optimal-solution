package com.mi.learn.Other;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/15 10:11 上午
 * @description 判断一个点是不是在矩形中 https://www.cnblogs.com/xiaobaizzz/p/12227288.html
 */
public class Inside {
    public boolean isInside(double x1, double x4, double y1, double y4, double x, double y) {
        if (x <= x1)
            return false;
        if (x >= x4)
            return false;
        if (y >= y1)
            return false;
        if (y <= y4)
            return false;
        return true;
    }

    public boolean isInside1(double x1, double y1, double x2, double y2, double x3, double y3,
                             double x4, double y4, double x, double y) {
        if (x1 == x3) {
            return isInside(x1, x4, y1, y4, x, y);
        }
        //旋转角的 sin 和 cos
        double l = y4 - y3;
        double k = x4 - x3;
        double s = Math.sqrt(k * k + l * l);
        double sin = l / s;
        double cos = k / s;
        double x1r = cos * x1 + sin * y1;
        double y1r = -x1 * sin + y1 * cos;
        double x4r = cos * x4 + sin * y4;
        double y4r = -x4 * sin + y4 * cos;
        double xr = cos * x + sin * y;
        double yr = -x * sin + y * cos;
        return isInside(x1r, x4r, y1r, y4r, xr, yr);
    }
}
