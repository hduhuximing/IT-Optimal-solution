package com.mi.learn.Node_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/23 9:53 下午
 * @description 两个单链表生成相加链表
 */
public class SumNode {
    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node addList(Node node1, Node node2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (node1 != null) {
            stack1.push(node1.value);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2.value);
            node2 = node2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node pre=null;
        Node cur=null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n=n1+n2+ca;
            ca=n/10;
            n%=10;
            pre=cur;
            cur=new Node(n);
            cur.next=pre;
        }
        if(ca==1){
            pre=cur;
            cur=new Node(1);
            cur.next=pre;
        }
        return cur;
    }

}
