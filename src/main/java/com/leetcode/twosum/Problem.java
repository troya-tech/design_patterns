package com.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

class Problem {
    public int[] twoSum(int[] nums, int target) {
//        return null;

        Map<Integer,Integer> hm = new HashMap<>();
        int remain;

        for(int i =0 ;i<nums.length;i++){
            remain = target - nums[i];

            if(hm.containsKey(remain)) return new int[]{i, remain};

            hm.put(nums[i], i );

        }
       throw new RuntimeException();
    }

}
