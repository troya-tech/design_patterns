package com.leetcode.dynamic.minimum.costfortickets;

// link: https://chatgpt.com/g/g-p-69b6f2f058c48191b499a1451ffb687a-dynamic-programming/c/69b6fe88-363c-838a-841c-ee503345ccd3

class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20},
                new int[]{2, 7, 15}
        )); // 11

        System.out.println(solution.mincostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31},
                new int[]{2, 7, 15}
        )); // 17
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] options = {1, 7, 30};
        return dfs(days, costs, options, 0);
    }

    private int dfs(int[] days, int[] costs, int[] options, int i) {
        if (i == days.length) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < 3; k++) {
            int d = options[k];
            int c = costs[k];

            int j = i;
            while (j < days.length && days[j] < days[i] + d) {
                j++;
            }

            ans = Math.min(ans, c + dfs(days, costs, options, j));
        }

        return ans;
    }
}
