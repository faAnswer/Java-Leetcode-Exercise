package com.leetcode;

public class Leetcode404 {

    private Integer sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null){

            return 0;
        }

        if(root.left == null && root.right == null){

            return 0;
        }

        helper(root, "");

        return this.sum;
    }

    private void helper(TreeNode root, String direction){

        if(root == null){

            return;
        }

        if(root.left == null && root.right == null){

            if(direction.equals("left")){

                this.sum += root.val;
            }
            return;
        }

        helper(root.left, "left");
        helper(root.right, "right");
    }
}
