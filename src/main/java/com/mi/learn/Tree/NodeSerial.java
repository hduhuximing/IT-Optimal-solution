package com.mi.learn.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 10:28 上午
 */
public class NodeSerial {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public String serial(Node root) {
        if (root == null) {
            return "#!";
        }
        String res = new String(root.value + "!");
        res += serial(root.left);
        res += serial(root.right);
        return res;
    }

    public Node recoverString(String str) {
        String[] split = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String str1 : split) {
            queue.offer(str1);
        }
        return help(queue);
    }

    private Node help(Queue<String> queue) {
        String poll = queue.poll();
        if (poll.equals("#")) {
            return null;
        }
        Node curr = new Node(Integer.valueOf(poll));
        curr.left = help(queue);
        curr.right = help(queue);
        return curr;
    }
}
