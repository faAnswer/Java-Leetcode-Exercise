package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode129BFS {
    public static void main(String[] args) {

        Leetcode129BFS sol = new Leetcode129BFS();

        TreeNode node = GenNewTree.insertLevelOrder(new int[]{1, 2, 3}, 0);

        System.out.println(sol.sumNumbers(node));
    }

    public int sumNumbers(TreeNode root) {

        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        Queue<String> nodeS = new LinkedList<String>();

        Integer sum = 0;

        nodeQ.offer(root);
        nodeS.offer("");

        while (!nodeQ.isEmpty()) {

            TreeNode currNode = nodeQ.poll();
            String currS = nodeS.poll() + currNode.val;

            if(currNode.left == null && currNode.right == null){

                sum += Integer.parseInt(currS);
            }

            if(currNode.left != null) {

                nodeQ.offer(currNode.left);
                nodeS.offer(currS);
            }

            if(currNode.right != null) {

                nodeQ.offer(currNode.right);
                nodeS.offer(currS);
            }
        }

        return sum;
    }
}
