package com.leetcode;

public class Leetcode572 {

    private String subRootPostOrder = "";

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        helper1(subRoot);

        try{

            helper2(root);

        } catch (Exception e){

          return true;
        }

        return false;
    }

    private void helper1(TreeNode root){

        if(root == null){

            this.subRootPostOrder += "0";
            return;
        }

        helper1(root.left);
        helper1(root.right);

        this.subRootPostOrder += root.val;
    }

    private String helper2(TreeNode root) throws Exception {

        if(root == null){

            return "0";
        }

        String left = helper2(root.left);
        String right = helper2(root.right);

        String rootPostOrder = left + right + root.val;

        if((rootPostOrder).equals(this.subRootPostOrder)){

            throw new Exception("OK");
        }

        return rootPostOrder;
    }
}
