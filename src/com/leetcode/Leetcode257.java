package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) return res;

        helper(root, "");

        return this.res;

    }

    private void helper(TreeNode root, String path) {

        if(root == null) return;

        if(path.equals("")){

            path = "" + root.val;

        } else {

            path = path + "->" + root.val;
        }

        if(root.left == null && root.right == null){

            this.res.add(path);
            return;
        }

        helper(root.left, path);
        helper(root.right, path);
    }

}
