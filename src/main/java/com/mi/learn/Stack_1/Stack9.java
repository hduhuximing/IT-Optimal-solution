package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/16 7:44 下午
 */
public class Stack9 {
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int length = map[0].length;
        int[] list = new int[length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < length; j++) {
                list[j] = map[i][j] == 0 ? 0 : list[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(list), maxArea);
        }
        return maxArea;
    }

    private int maxRecFromBottom(int[] list) {
        if (list == null || list.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            while (!stack.isEmpty() && list[stack.peek()] >= list[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (j - k - 1) * list[i];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (list.length - k - 1) * list[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

}
