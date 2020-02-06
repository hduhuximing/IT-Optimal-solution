package com.mi.learn.Node_1;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 9:51 上午
 */
public class MergeNode {
    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node Merge(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.value < l2.value) {
            l1.next = Merge(l1.next, l2);
            return l1;
        } else {
            l2.next = Merge(l1, l2.next);
            return l2;
        }

    }
}
