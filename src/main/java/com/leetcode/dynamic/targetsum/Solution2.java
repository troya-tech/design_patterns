package com.leetcode.dynamic.targetsum;

// decision odagi nums degil +, - yapabilir miyz

//class Solution2 {
//
//    public static void main(String[] args) {
//        Solution2 solution = new Solution2();
//
//        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
//        System.out.println(solution.findTargetSumWays(new int[]{1}, 1));               // 1
//        System.out.println(solution.findTargetSumWays(new int[]{1}, 2));               // 0
//        System.out.println(solution.findTargetSumWays(new int[]{2, 1}, 1));            // 1
//        System.out.println(solution.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)); // 256
//    }
//
//    public int findTargetSumWays(int[] nums, int target) {
//        return backtrack(nums, 0, target);
//    }
//
//    private int backtrack(int[] nums, int i, int remain) {
//        if (i == nums.length) {
//            return remain == 0 ? 1 : 0;
//        }
//
//        if(i==0){
//
//
//        }
//        if(i==1){
//
//        }
//        i=0;
//
//
////        return backtrack(nums, i + 1, remain - nums[i])
////                + backtrack(nums, i + 1, remain + nums[i]);
//    }
//}
