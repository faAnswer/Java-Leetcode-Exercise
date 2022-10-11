package com.leetcode;

public class Leetcode114 {
    public static void main(String[] args) {

        GenNewTree genNewTree = new GenNewTree();

        TreeNode tarTree = genNewTree.insertLevelOrder(new int[]{1,2,5,3,4,-999,6}, 0);

        flatten(tarTree);

        System.out.println("Done");
    }
    public static void flatten(TreeNode root) {

        helper(root);

    }
    public static TreeNode helper(TreeNode root) {

        if(root == null)
            return null;

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        TreeNode newNode = pushRight(left, right);

        root.left = null;
        root.right = newNode;

        return root;

    }
    public static TreeNode pushRight(TreeNode rleft, TreeNode rright) {

        if(rleft == null & rright == null){

            return null;
        } else if(rleft == null){

            return rright;
        } else if(rright == null){

            return rleft;
        }

        if(rleft.right == null){

            rleft.right = rright;


            return rleft;
        } else {

            TreeNode _nodt = rleft;

            TreeNode _newNode = pushRight(rleft.right, rright);

            return _nodt;
        }
    }
}
