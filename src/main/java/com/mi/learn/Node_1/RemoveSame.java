package com.mi.learn.Node_1;

import com.mi.learn.Stack_1.DeleteNum;

import java.util.HashSet;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 9:39 上午
 */
public class RemoveSame {
    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void Remove(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node curr = head;
        set.add(curr.value);
        while (curr != null) {
            if (set.contains(curr.value)) {
                pre.next = curr.next;
            } else {
                pre = curr;
                set.add(curr.value);
            }
            curr = curr.next;
        }

    }
}
