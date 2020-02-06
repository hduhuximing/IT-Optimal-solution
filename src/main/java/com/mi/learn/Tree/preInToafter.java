package com.mi.learn.Tree;

import java.util.HashMap;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 8:25 下午
 * @description 先序中序-》后序
 */
public class preInToafter {
    static int index = 0;

    public static int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = in.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        index = len - 1;
        help1(pre, 0, len - 1, in, 0, len - 1, pos, map);
//        help(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    private static void help1(int[] pre, int pi, int pj, int[] in, int ni, int nj, int[] pos, HashMap<Integer, Integer> map) {
        if(pi>pj){
            return ;
        }
        pos[index--] = pre[pi];
        //获取在中序的位置
        int i = map.get(pre[pi]);
        //后-》左右根，反过来-》根右左
        //先向右走
        help1(pre, pi + i - ni + 1, pj, in, i + 1, nj, pos, map);
        help1(pre, pi + 1, pi + i - ni, in, ni, i - 1, pos, map);
    }

    private static int help(int[] pre, int pi, int pj, int[] in, int ni, int nj, int[] pos, int s, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return s;
        }
        pos[s--] = pre[pi];
        //获取在中序的位置
        int i = map.get(pre[pi]);
        //后-》左右根，反过来-》根右左
        //先向右走
        s = help(pre, pi + i - ni + 1, pj, in, i + 1, nj, pos, s, map);
        return help(pre, pi + 1, pi + i - ni, in, ni, i - 1, pos, s, map);
    }

    public static void main(String[] args) {
        int[] s1 = {1, 2, 4, 5, 3, 6, 7};
        int[] s2 = {4, 2, 5, 1, 6, 3, 7};
        int[] posArray = getPosArray(s1, s2);
        for (int i : posArray) {
            System.out.println(i);
        }
    }
}
