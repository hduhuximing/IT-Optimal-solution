package com.mi.learn.Stack_1;

import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/1 10:22 下午
 */


public class DeleteNum {
    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node removeNum(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    public Node removeNum2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node curr = head;
        while (curr != null) {
            if (curr.value == num) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
