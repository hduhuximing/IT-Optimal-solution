package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/10 2:50 下午
 */
public class Stack3 {
    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result=stack.pop();
        if(stack.isEmpty()){
            //获取到栈低元素，返回，
            return result;
        }else{
            int last=getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

}
