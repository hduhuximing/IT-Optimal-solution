package com.mi.learn.Array;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/9 6:50 下午
 * @description 矩阵旋转90度
 */
public class rount {
    public static void rotate(int[][] matrix) {
        //行
        int tR = 0;
        //列
        int tC = 0;
        int dR = matrix.length;
        int dC = matrix[0].length;
        while (tR < dR) {
            int times = dR - tR;
            int temp = 0;
            for (int i = 0; i < times; i++) {
                temp = matrix[tR][tC + i];
                matrix[tR][tC + i] = matrix[dR - i][tC];
                matrix[dR - i][tC] = matrix[dR][dC - i];
                matrix[dR][dC - i] = matrix[tR + i][dC];
                matrix[tR + i][dC] = temp;
                tR++;
                tC++;
                dR--;
                dC--;
            }
        }
    }
}
