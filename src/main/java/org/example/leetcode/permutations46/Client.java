//package org.example.leetcode.permutations46;
//
//public class Client {
//}
//
//class Solution {
//    public List<List<Integer>> permute(int[] nums) {
//        return bt(new ArrayList<>(), new ArrayList<>(), nums,new int[nums.length]);
//    }
//
//    private List<List<Integer>> bt(
//        List<List<Integer>> res,
//        List<Integer> temp,
//        int[] cand,
//        int[] isUsed
//    ){
//
//        if(temp.size() ==cand.length) res.add(new ArrayList<>(temp));
//
//        for(int i = 0;i<cand.length;i++){
//
//            if(isUsed[i] == 1) continue;
//
//            temp.add(cand[i]);
//            isUsed[i] =1;
//            bt(res, temp, cand, isUsed);
//            isUsed[i] =0;
//            temp.remove(temp.size()-1);
//
//        }
//
//        return res;
//    }
//}