package com.leetcode;

public class Leetcode297 {
    public static void main(String[] args) {

        TreeNode node = GenNewTree.insertLevelOrder(new int[]{1,2}, 0);

        String result = serialize(node);

        TreeNode trr = deserialize(result);

        String[] preS = "XX_XXXXX".split("_");
        System.out.println(result);

    }

    public static String inres = "";
    public static String preres = "";
    public static String serialize(TreeNode root) {

        if (root == null) return "X";
        if (root.val == -999) {

            return "";
        }
        preres = preres + root.val;
        serialize(root.left);
        inres = inres + root.val;
        serialize(root.right);

        return preres + "_" + inres;
    }
    public static TreeNode deserialize(String data) {

        String preOrder = data.split("_")[0];
        String inOrder = data.split("_")[1];

        if(preOrder.length() == 0) return new TreeNode();

        if(preOrder.length() == 1){

            if(preOrder.equals("X")) return null;

            return new TreeNode(Integer.parseInt(preOrder));
        }
        if(preOrder.length() == 2){

            TreeNode newT = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(0))));

            newT.left = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(1))));

            return newT;
        }
        if(preOrder.length() == 3){

            TreeNode newT = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(0))));

            newT.left = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(1))));
            newT.left = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(1))));

            return newT;
        }
        char rootVal = preOrder.charAt(0);

        int rootp = inOrder.indexOf(rootVal);
        int leftLen = rootp;

        String leftin = inOrder.substring(0, rootp);
        String leftPer = preOrder.substring(1, 1 + rootp);

        String rightin = inOrder.substring(rootp + 1, inOrder.length());
        String rightPer = preOrder.substring(1 + rootp, preOrder.length());


        TreeNode leftNode = deserialize(leftPer + "_" + leftin);

        TreeNode rightNode = deserialize(rightPer + "_" + rightin);

        TreeNode newNode = new TreeNode(Integer.parseInt(String.valueOf(preOrder.charAt(0))), leftNode, rightNode);

        return newNode;
    }
}
