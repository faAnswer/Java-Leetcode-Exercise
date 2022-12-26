package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> integerList = new ArrayList<>();

        helper(root, integerList, targetSum);

        return this.res;


    }

    public void helper(TreeNode root, List<Integer> currentList, Integer currentSum){

        if(root == null) return;

        if(root.left == null && root.right == null){

            if(currentSum == root.val){

                List<Integer> integerList = new ArrayList<Integer>(currentList);

                integerList.add(root.val);

                this.res.add(integerList);
            }

            return;
        }

        Integer remainingSum = currentSum - root.val;

        List<Integer> integerLeftList = new ArrayList<Integer>(currentList);

        integerLeftList.add(root.val);


        List<Integer> integerRightList = new ArrayList<Integer>(currentList);

        integerRightList.add(root.val);

        helper(root.left, integerLeftList, remainingSum);
        helper(root.right, integerRightList, remainingSum);

    }
}
