package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode145 {

    private List<Integer> res = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {

        if(root == null) return res;

        helper(root);

        return this.res;
    }

    private void helper(TreeNode root){

        if(root == null){

            return;
        }

        helper(root.left);
        helper(root.right);

        this.res.add(root.val);

    }
}
