package com.leetcode;

public class Leetcode35 {

    public static void main(String[] args) {

        Leetcode35 sol = new Leetcode35();



        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 2));
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int last = 0;

        while(left <= right) {

            int mid = left + (right - left)/2;
            int midVal = nums[mid];

            if(midVal == target) {

                return mid;

            } else if (midVal < target) {

                left = mid + 1;

            } else if (midVal > target) {

                right = mid - 1;
                last = mid;

            }
        }

        return last;
    }
}
