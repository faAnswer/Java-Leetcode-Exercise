package com.leetcode;

import java.util.*;
import java.util.ArrayList;

public class Leetcode96 {

    public static void main(String[] args) {

        ArrayList<Integer> _curr = new ArrayList<Integer>();

        ArrayList<Integer> _select = new ArrayList<Integer>();

        _select.add(1);
        _select.add(2);
        _select.add(3);

        List<Integer> _select2 = Arrays.stream(new int[]{1, 2, 3}).boxed().toList();

        helper(_curr, _select);

        System.out.println("A");

    }

    public int numTrees(int n) {

        return 1;
    }
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void helper(ArrayList<Integer> currList, ArrayList<Integer> selectList) {

        if(selectList.size() == 0) {

            res.add(currList);
            return;
        }

        for(int i = 0; i < selectList.size(); i++) {

            if(currList.contains(selectList.get(i))) {

                continue;
            }

            ArrayList<Integer> newCurrList = new ArrayList<Integer>();
            newCurrList.addAll(currList);
            newCurrList.add(selectList.get(i));

            ArrayList<Integer> newselectList = new ArrayList<Integer>();
            newselectList.addAll(selectList);
            newselectList.remove(i);
            helper(newCurrList, newselectList);
        }
    }

}
