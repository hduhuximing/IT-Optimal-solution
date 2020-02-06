package com.mi.learn.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 11:46 上午
 */
public class levelOrder {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size() - 1 - level).add(root.val);
        helper(root.left,res,level+1);
        helper(root.right,res,level+1);
    }
}