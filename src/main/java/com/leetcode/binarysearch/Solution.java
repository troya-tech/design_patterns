package com.leetcode.binarysearch;

// https://leetcode.com/problems/binary-search/description/
class Solution {
    public int search(int[] nums, int target) {

        int l=0;
        int r=nums.length-1;
        int middle =0;

        while(l<=r){
            middle = ((r-l)/2) + l;

            if( nums[middle] == target ) return middle;
            if(nums[middle] > target) r =middle-1;
            if(nums[middle] < target) l =middle +1;
        }
        return -1;
    }
}
