package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/10 3:26 下午
 */
public class Stack2 {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public Stack2(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPop = stackPop;
        this.stackPush = stackPush;
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            System.out.println("队列为空");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            System.out.println("队列为空");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
