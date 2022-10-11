package com.leetcode;
import java.util.*;

public class Leetcode654 {
    public static void main(String[] args) {

        constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);

        int max = Arrays.stream(nums).max().getAsInt();
        int maxp = Arrays.stream(nums).boxed().toList().indexOf(max);

        int[] leftArr = Arrays.copyOfRange(nums, 0, maxp);
        int[] rightArr = Arrays.copyOfRange(nums, maxp + 1, nums.length);

        TreeNode leftTree = constructMaximumBinaryTree(leftArr);
        TreeNode rightTree = constructMaximumBinaryTree(rightArr);

        TreeNode newTree = new TreeNode(max, leftTree, rightTree);

        return newTree;

    }
}
