package com.leetcode.dynamic.targetsum;

// link chatgpt https://chatgpt.com/c/69b6be04-6dc0-8385-8246-110119a9fd0a

class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(solution.findTargetSumWays(new int[]{1}, 1));               // 1
        System.out.println(solution.findTargetSumWays(new int[]{1}, 2));               // 0
        System.out.println(solution.findTargetSumWays(new int[]{2, 1}, 1));            // 1
        System.out.println(solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)); // 256
    }

    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target);
    }

    private int backtrack(int[] nums, int i, int remain) {
        if (i == nums.length) {
            return remain == 0 ? 1 : 0;
        }

        return backtrack(nums, i + 1, remain - nums[i])
                + backtrack(nums, i + 1, remain + nums[i]);
    }
}
