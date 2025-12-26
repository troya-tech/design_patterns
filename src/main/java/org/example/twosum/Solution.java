package org.example.twosum;

import java.util.HashMap;
import java.util.Map;


class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hm.containsKey(complement)) {
                return new int[]{i, hm.get(complement)};
            }

            hm.put(nums[i], i);
        }

        // LeetCode guarantees a solution exists
        throw new IllegalArgumentException("No two sum solution");
    }
}
