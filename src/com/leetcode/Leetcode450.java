package com.leetcode;

public class Leetcode450 {

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode newTree = new TreeNode();

        if (root == null) {
            return root;
        }

        if(root.val == key) {

            if(root.left == null & root.right == null) {

                return null;
            } else if(root.right != null & root.left != null){

                newTree = addTree(root.left, root.right);
            } else if(root.left != null & root.right == null){

                newTree = root.left;
            } else if(root.right != null & root.left == null){

                newTree = root.right;

            }
            return newTree;
        }

        root.right = deleteNode(root.right, key);
        root.left = deleteNode(root.left, key);

        return root;
    }
    public TreeNode addTree (TreeNode left, TreeNode right) {

        boolean success = false;
        TreeNode _root = right;

        while(success == false){

            if(right.left == null){

                right.left = left;
                success = true;

            } else {

                right = right.left;
            }

        }
        return _root;
    }

}
