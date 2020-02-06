package com.mi.learn.Tree;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 12:13 下午
 */
public class revocerTree {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void recoverTree1(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        helper(pre, first, second, root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    //中序遍历
    private void helper(TreeNode pre, TreeNode first, TreeNode second, TreeNode root) {
        if(root==null){
            return ;
        }
        helper(pre,first,second,root.left);
        //处理
        if(pre!=null&&pre.val>=root.val){
            if(first==null){
                first=pre;
            }
                second=root;

        }
        pre=root;
        helper(pre,first,second,root.right);

    }
}