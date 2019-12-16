package com.mi.learn.Stack_1;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2019/12/13 3:15 下午
 */
class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
//解法：找到第一个比当前大的数
public class Stack8 {
    public Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        //将数据存入Node中
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        //栈作为存储当前大的数据
        Stack<Node> stack = new Stack<>();
        //两个map存储当前数据左边和右边最大的数据
        HashMap<Node, Node> lBig = new HashMap<>();
        HashMap<Node, Node> rBig = new HashMap<>();
        //找到每个数据左边第一个比当前大的
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                //弹出到map中
                popStack(stack, lBig);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStack(stack, lBig);
        }
        //找到右边第一个比当前大的
        for (int i = arr.length - 1; i >= 0; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                //弹出到map中
                popStack(stack, lBig);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStack(stack, rBig);
        }
        //生成树
        Node head = null;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBig.get(curNode);
            Node right = rBig.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    private void popStack(Stack<Node> stack, HashMap<Node, Node> Big) {
        Node node = stack.pop();
        if (stack.isEmpty()) {
            Big.put(node, null);
        } else {
            Big.put(node, stack.peek());
        }
    }
}
