package com.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
    public static void main(String[] args) {

        Leetcode199 cl = new Leetcode199();

        TreeNode root = GenNewTree.insertLevelOrder(new int[] {1, 2, 3, -999, 5, -999, 4},0);

        List<Integer> ans = cl.rightSideView(root);

        System.out.println(ans);
    }

    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<>();

        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<Integer> deepQ = new LinkedList<Integer>();

        List<Integer> res = new ArrayList<>();

        nodeQ.offer(root);
        deepQ.offer(0);

        while (!nodeQ.isEmpty()) {

            TreeNode currNode = nodeQ.poll();
            Integer currDeep = deepQ.poll();

            if(res.size() < currDeep + 1){

                res.add(currNode.val);

            } else {

                res.set(currDeep, currNode.val);
            }

            if(currNode.left != null && currNode.left.val != -999 ){

                nodeQ.offer(currNode.left);
                deepQ.offer(currDeep + 1);
            }

            if(currNode.right != null && root.right.val != -999){

                nodeQ.offer(currNode.right);
                deepQ.offer(currDeep + 1);
            }
        }

        return res;
    }

}
