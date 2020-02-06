package com.mi.learn.Stack_1;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 7:24 下午
 * @description 使用数组实现栈
 * 自己实现一个栈，要求这个栈具有push()、pop()（返回栈顶元素并出栈）、
 * peek() （返回栈顶元素不出栈）、isEmpty()、size()这些基本的方法。
 * 提示：每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容；
 */
public class MinStack {
    private int[] storage;//存放栈中元素的数组
    private int capacity;//栈的容量
    //下一个要添加的位置坐标，也是当前元素个数
    private int count;//栈中元素数量
    private static final int GROW_FACTOR = 2;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.capacity = 8;
        this.count = 0;
        this.storage = new int[capacity];
    }

    public MinStack(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.storage = new int[capacity];
    }

    //TODO 扩容机制
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    //TODO：入栈
    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
        if (value < min) {
            min = value;
        }
    }

    //TODO：返回栈顶元素并出栈
    private int pop() {
        count--;
        if (count == -1) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        if (storage[count] == min) {
            min = storage[0];
            for (int i = 1; i <= count; i++) {
                if (storage[i] < min) {
                    min = storage[i];
                }
            }
        }
        return storage[count];
    }

    //TODO：返回栈顶元素不出栈
    private int peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        } else {
            return storage[count - 1];
        }
    }
    //TODO 返回最小
    private int getMin() {
        if(min==Integer.MAX_VALUE){
            throw new IllegalArgumentException("当前未添加数据");
        }
        return min;
    }

    //TODO：判断栈是否为空
    private boolean isEmpty() {
        return count == 0;
    }

    //TODO：返回栈中元素的个数
    private int size() {
        return count;
    }
}
