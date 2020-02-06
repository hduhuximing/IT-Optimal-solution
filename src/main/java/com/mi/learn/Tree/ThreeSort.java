package com.mi.learn.Tree;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 9:59 上午
 */
public class ThreeSort {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void pre(Node root) {
        //结束条件
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        pre(root.left);
        pre(root.right);
    }

    public void pre1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.value);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }


    public void mid(Node root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        System.out.println(root.value);
        mid(root.right);
    }

    public void after(Node root) {
        if (root == null) {
            return;
        }
        after(root.left);
        after(root.right);
        System.out.println(root.value);
    }


}
