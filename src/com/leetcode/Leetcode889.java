package com.leetcode;

import java.util.Arrays;

public class Leetcode889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        if(preorder.length == 0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);

        int rootVal = preorder[0];
        int secondVal = preorder[1];

        int secp = Arrays.stream(postorder).boxed().toList().indexOf(secondVal);
        int sccLen = secp + 1;

        int[] leftPer = Arrays.copyOfRange(preorder,1, sccLen + 1);
        int[] leftPost = Arrays.copyOfRange(postorder,0, secp + 1);

        int[] rightPer = Arrays.copyOfRange(preorder,1 + sccLen, preorder.length);
        int[] rightPost = Arrays.copyOfRange(postorder,secp + 1, preorder.length -1);

        TreeNode leftNode = constructFromPrePost(leftPer, leftPost);
        TreeNode rightNode = constructFromPrePost(rightPer, rightPost);

        TreeNode newNode = new TreeNode(preorder[0], leftNode, rightNode);

        return newNode;
    }
}
