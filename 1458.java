/* 
Leetcode : 1458
https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/

*/


class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[501][501];
        for(int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -100000000);
        }

        return solve(nums1, nums2, 0, 0, m, n, dp);
    }

    public int solve(int[] nums1, int[] nums2, int i, int j, int m, int n, int[][] dp) {
        if(i == m || j == n)
            return -100000000;

        if(dp[i][j] != -100000000) return dp[i][j];

        int val = nums1[i] * nums2[j];

        int take_i_j = solve(nums1, nums2, i + 1, j + 1, m, n, dp) + val;
        int take_i = solve(nums1, nums2, i, j + 1, m, n, dp);
        int take_j = solve(nums1, nums2, i + 1, j, m, n, dp);

        return dp[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i, take_j)));
    }
}