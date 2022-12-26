package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {

    private List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return res;

        helper(root);

        return this.res;

    }

    private void helper(TreeNode root){

        if(root == null){

            return;

        } else {

            this.res.add(root.val);
        }

        helper(root.left);
        helper(root.right);

    }

}
