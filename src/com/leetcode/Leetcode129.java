package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode129 {

    public static void main(String[] args) {

        Leetcode129 sol = new Leetcode129();

        TreeNode node = GenNewTree.insertLevelOrder(new int[]{0, 1}, 0);

        sol.sumNumbers(node);
    }
    List<Integer> res = new ArrayList<Integer>();

    public int sumNumbers(TreeNode root) {

        helper("", root);

        Integer[] arr = res.toArray(new Integer[]{});

        return Arrays.stream(arr).reduce(0, Integer::sum);

    }

    public void helper(String currPath, TreeNode root) {

        if(root == null) return;

        String path = currPath + root.val;

        if(root.left == null && root.right == null){

            res.add(Integer.valueOf(path));
            return;
        }

        helper(path, root.left);
        helper(path, root.right);
    }
}
