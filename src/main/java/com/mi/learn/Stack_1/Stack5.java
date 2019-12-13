package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/13 11:02 上午
 */
public class Stack5 {
    public static  void sortStackByStack(Stack<Integer>stack){
        Stack<Integer>help=new Stack<>();
        while(!stack.isEmpty()){
            int cur=stack.pop();
            if(!help.isEmpty()&&cur>help.peek()){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
