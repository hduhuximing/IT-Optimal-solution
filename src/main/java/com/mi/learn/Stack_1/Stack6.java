package com.mi.learn.Stack_1;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/13 2:26 下午
 */
public class Stack6 {
    public int hanoiProblom(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    private int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("move 1 from " + from + " to " + mid);
                System.out.println("move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = from.equals(right) || to.equals(right) ? left : right;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("move 1 from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("move 1 from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("move 1 from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
