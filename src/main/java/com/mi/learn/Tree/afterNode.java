package com.mi.learn.Tree;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/4 8:47 下午
 * @description
 */
public class afterNode {
    class Node {
        private Node left;
        private Node right;
        private Node parent;
        private int value;

        public Node(int value) {
            this.value = value;
        }
        //前继节点，有右节点就是，右节点的最左边
        //没有右节点，找到父节点，如果当前节点是父节点的左节点，父节点就是后继节点。
        public Node getNextNode(Node root) {
            if(root==null){
                return root;
            }
            if(root.right!=null){
                return getLeftMost(root.right);
            }else{
                Node parent=root.parent;
                while(parent!=null&&parent.left!=root){
                    root=parent;
                    parent=root.parent;
                }
                return parent;
            }

        }

        public Node getLeftMost(Node root) {
            if (root == null) {
                return root;
            }
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
}
