package com.leetcode;

public class GenNewTree {

    public static TreeNode insertLevelOrder(int[] arr, int i)
    {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

}
