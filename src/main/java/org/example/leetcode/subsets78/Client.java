package org.example.leetcode.subsets78;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {


        return bt(
                new ArrayList<>(),
                new ArrayList<>(),
                nums,
                0
        );
    }

    private List<List<Integer>> bt(
            List<List<Integer>> res,
            List<Integer> temp,
            int[] cand,
            int p
    ) {

        res.add(new ArrayList<>(temp));


        for (int i = p; i < cand.length; i++) {

            temp.add(cand[i]);
            bt(res, temp, cand, i + 1);
            temp.remove(temp.size() - 1);
        }

        return res;
    }
}