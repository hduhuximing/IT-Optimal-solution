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
    //获取栈低数据并移除
    public int getAndRemoveLastElement(Stack<Integer> stack) {
        //获取当前的值
        int result=stack.pop();
        if(stack.isEmpty()){
            //获取到栈低元素，返回，
            return result;
        }else{
            //递归获取当前遍历的数据
            int last=getAndRemoveLastElement(stack);
            //将当前遍历的数据插入回数组中
            stack.push(result);
            return last;
        }
    }

}
