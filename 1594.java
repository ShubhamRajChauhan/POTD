/* 
Leetcode : 1594
https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/
*/

//-----------------------------------Recursion + Memoization------------------------------------------
class Solution {
    int m, n;
    int MOD = 1000000007;

    public Pair<Long, Long> solve(int i, int j, int[][] grid, Pair<Long, Long>[][] dp) {
        //Base case: If we are at the bottom-right corner, return the value
        if(i == m - 1 && j == n - 1) {
            return new Pair<>((long) grid[i][j], (long) grid[i][j]);
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        //if already computed, return the memoized result
        if(dp[i][j] != null) {
            return dp[i][j];
        }

        //move down
        if(i + 1 < m) {
            Pair<Long, Long> down = solve(i + 1, j, grid, dp);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * down.getKey(), grid[i][j] * down.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * down.getKey(), grid[i][j] * down.getValue()));
        }

        //move right
        if(j + 1 < n) {
            Pair<Long, Long> right = solve(i, j + 1, grid, dp);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * right.getKey(), grid[i][j] * right.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * right.getKey(), grid[i][j] * right.getValue()));
        }

        return dp[i][j] = new Pair<>(maxVal, minVal);
    }

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Pair<Long, Long>[][] dp = new Pair[m][n];

        //get the result from the top-left corner
        Pair<Long, Long> result = solve(0, 0, grid, dp);

        //if the result is negative, return -1, otherwise return the result modulo MOD
        return result.getKey() < 0 ? -1 : (int) (result.getKey() % MOD);
    }
}





//-----------------------------------Bottom Up------------------------------------------
class Solution {
    int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Pair<Long, Long>[][] dp = new Pair[m][n];

        //Base case: starting point
        dp[0][0] = new Pair<>((long) grid[0][0], (long) grid[0][0]);
        //fill the first row
        for(int j = 1; j < n; j++) {
            dp[0][j] = new Pair<>(dp[0][j - 1].getKey() * grid[0][j], dp[0][j - 1].getValue() * grid[0][j]);
        }
        //fill the first column
        for(int i = 1; i < m; i++) {
            dp[i][0] = new Pair<>(dp[i - 1][0].getKey() * grid[i][0], dp[i - 1][0].getValue() * grid[i][0]);
        }


        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long upMax = dp[i - 1][j].getKey();
                long upMin = dp[i - 1][j].getValue();

                long leftMax = dp[i][j - 1].getKey();
                long leftMin = dp[i][j - 1].getValue();

                dp[i][j] = new Pair<>(
                    Math.max(Math.max(upMax * grid[i][j], upMin * grid[i][j]), Math.max(leftMax * grid[i][j], leftMin * grid[i][j])),
                    Math.min(Math.min(upMax * grid[i][j], upMin * grid[i][j]), Math.min(leftMax * grid[i][j], leftMin * grid[i][j]))
                );
            }
        }

        //get the result from the bottom-right corner
        long maxProd = dp[m - 1][n - 1].getKey();

        //if the result is negative, return -1, otherwise return the result modulo MOD
        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }
}