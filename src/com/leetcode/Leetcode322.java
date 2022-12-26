package com.leetcode;

import java.util.*;

public class Leetcode322 {

    public static void main(String[] args) {

        Leetcode322 sol = new Leetcode322();

        System.out.println(sol.coinChange(new int[] {2, 5, 10, 1}, 27));

    }

    public List<Integer> coins = null;
    public HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int coinChange(int[] coins, int amount) {

        if(amount % Arrays.stream(coins).max().getAsInt() == 0){

            return amount/Arrays.stream(coins).max().getAsInt();
        }

        this.coins = Arrays.stream(coins).boxed().toList();
        helper(amount);

        if(amount == 0) {return 0;}

        if(this.map.containsKey(amount)){

            return this.map.get(amount);

        } else {

            return -1;
        }
    }

    public void helper(Integer currLeft){

        if(currLeft < 0){

            return;
        }

        for(int i = 0; i < this.coins.size(); i++){

            Integer currNum = this.coins.get(i);

            if(currNum > currLeft){

                continue;
            }

            if(currNum == currLeft){

                map.put(currLeft, 1);
                return;
            }

            helper(currLeft - currNum);

            if(this.map.containsKey(currLeft - currNum)){

                map.put(currLeft, this.map.get(currLeft - currNum) + 1);
            }
        }
    }
}
