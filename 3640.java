/* 
Leetcode : 3640
https://leetcode.com/problems/trionic-array-ii/description/
*/

class Solution {
    static final long NEG_INF = Long.MIN_VALUE / 2;

    long solve(int i, int direction, int[] nums, int n, long[][] dp) {
        if(i == n) return (direction == 3) ? 0 : NEG_INF;
        
        if(dp[i][direction] != Long.MIN_VALUE) return dp[i][direction];
        
        long take = NEG_INF;
        long skip = NEG_INF;

        if(direction == 0) skip = solve(i + 1, 0, nums, n, dp);
        if(direction == 3) take = nums[i];

        if(i + 1 < n) {
            int curr = nums[i];
            int next = nums[i + 1];

            if(direction == 0 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 1, nums, n, dp));
            } 
            else if (direction == 1) {
                if(next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 1, nums, n, dp));
                } else if (next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums, n, dp));
                }
            } 
            else if (direction == 2) {
                if(next < curr) {
                    take = Math.max(take, curr + solve(i + 1, 2, nums, n, dp));
                } else if (next > curr) {
                    take = Math.max(take, curr + solve(i + 1, 3, nums, n, dp));
                }
            } 
            else if (direction == 3 && next > curr) {
                take = Math.max(take, curr + solve(i + 1, 3, nums, n, dp));
            }
        }

        return dp[i][direction] = Math.max(take, skip);
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n][4];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }

        return solve(0, 0, nums, n, dp);
    }
}