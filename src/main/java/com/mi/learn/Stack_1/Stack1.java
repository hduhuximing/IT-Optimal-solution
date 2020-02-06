package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/4 10:13 下午
 * @description 设计一个getmin功能的栈, 第二种方法，在插入的时候如果每次都判断，是否小于当前的min栈，
 * 不小于就将当前栈中最小的再次加入栈顶，保证了数据在出栈的时候直接两个栈都出栈
 */
public class Stack1 {
    private Stack<Integer> sk1;//作为添加数据的栈
    private Stack<Integer> sk2;//始终保存当前的最小值

    public Stack1() {
        this.sk1 = new Stack<>();
        this.sk2 = new Stack<>();
    }

    //方法一
    public void push(int newNum) {
        this.sk1.push(newNum);
        if (this.sk2.isEmpty()) {
            this.sk2.push(newNum);
            //不大于当前最小栈的头结点，弹出。
        } else if (newNum <= this.sk2.peek()) {
            this.sk2.push(newNum);
        }
    }

    public int pop() throws Exception {
        if (this.sk1.isEmpty()) {
            throw new Exception("没有数据了");
        }
        int value = this.sk1.pop();
        if (value <= this.sk2.peek()) {
            this.sk2.pop();
        }
        return value;
    }

    public int getMin() throws Exception {
        if (this.sk2.isEmpty()) {
            throw new Exception("当前栈中没有数据");
        }
        return sk2.peek();
    }

    //方法二
    public void push2(int newNum) {
        if (this.sk2.isEmpty()) {
            sk2.push(newNum);
        } else if (newNum > sk2.peek()) {
            int newNum1 = sk2.peek();
            sk2.push(newNum1);
        }
        sk1.push(newNum);
    }

    public int pop2() {
        Integer pop = sk1.pop();
        sk2.pop();
        return pop;
    }

    public int getMin2() {
        return sk2.peek();
    }
}