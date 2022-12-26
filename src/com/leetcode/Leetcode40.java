package com.leetcode;

import java.util.*;

public class Leetcode40 {

    private int target ;

    private Set checkSet = new HashSet();


    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {

        Leetcode40 test = new Leetcode40();

        List<List<Integer>> ans = test.combinationSum2(new int[]{10, 1, 2,7,6,1,5}, 8);

        System.out.println();
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        this.target = target;

        List<Integer> canList = new ArrayList<>();
        List<Integer> selectList = Arrays.stream(candidates).boxed().toList();

        if(Arrays.stream(candidates).sum() < target) {

            return res;
        }


        helper(canList, target, selectList);

        return res;

    }

    public void helper(List<Integer> canList, Integer reNum, List<Integer> selectList){

        if(selectList.isEmpty()){

            return;
        }

        for(int i = 0 ; i < selectList.size(); i++){

            if(reNum == selectList.get(i)){

                List<Integer> newConList = new ArrayList<>(canList);

                newConList.add(selectList.get(i));

                String someHash = "";

                newConList.sort((x,y) -> x-y);


                for(Integer j :newConList){

                    someHash += j.toString();

                }

                if(this.checkSet.contains(someHash)){

                    continue;

                } else{
                    this.checkSet.add(someHash);
                    this.res.add(newConList);

                    continue;
                }



            } else if (reNum > selectList.get(i)) {


                List<Integer> newConList = new ArrayList<>(canList);
                newConList.add(selectList.get(i));

                List<Integer> newSelectList = new ArrayList<>(selectList);

                newSelectList.remove(i);

                helper(newConList, reNum - selectList.get(i), newSelectList);


            } else {

                continue;

            }
        }

    }
}
