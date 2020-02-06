package com.mi.learn.Node_1;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/3 10:56 下午
 */
public class MakeNode {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void relocate(Node root) {
        if (root == null || root.next == null) {
            return;
        }
        //找到中间值
        Node mid = root;
        Node right = root.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right=mid.next;
        mid.next=null;
        merge(root,right);
    }

    private void merge(Node left, Node right) {
        Node next=null;
        while(left.next!=null){
            next=right.next;
            right.next=left.next;
            left.next=right;
            left=right.next;
            right=next;
        }
        left.next=right;
    }
}
