package com.leetcode;
import java.util.ArrayList;
import java.util.List;



public class Leetcode94 {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root == null){return new ArrayList<Integer>();}

        if(root.left != null){
            inorderTraversal(root.left);
        }
        res.add(root.val);

        if(root.right != null){
            inorderTraversal(root.right);
        }

        return res;
    }
}
