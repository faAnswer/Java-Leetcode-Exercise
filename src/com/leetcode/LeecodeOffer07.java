package com.leetcode;

import java.util.Arrays;

public class LeecodeOffer07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);

        int rootVal = preorder[0];
        int secVal = preorder[1];

        int rootp = Arrays.stream(inorder).boxed().toList().indexOf(rootVal);
        int leftLen = rootp;
        int rightLen = inorder.length - 1 - leftLen;

        int[] leftPer = Arrays.copyOfRange(preorder, 1,  leftLen + 1);
        int[] leftin = Arrays.copyOfRange(inorder, 0, leftLen + 1);

        int[] rightPer = Arrays.copyOfRange(preorder, leftLen + 1,  preorder.length);
        int[] rightin = Arrays.copyOfRange(inorder, rootp + 1, inorder.length);

        TreeNode leftTree = buildTree(leftPer, leftin);
        TreeNode rightTree = buildTree(rightPer, rightin);

        TreeNode newTree = new TreeNode(preorder[0], leftTree, rightTree);

        return newTree;

    }
}
