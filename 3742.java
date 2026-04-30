/* 
Leetcode : 3742
https://leetcode.com/problems/maximum-path-score-in-a-grid/description/
*/


//Recursion:
class Solution {
    int m, n;
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int result = solve(grid, k, 0, 0, 0);

        return result == Integer.MIN_VALUE ? -1 : result;
    }

    public int solve(int[][] grid, int k,int i, int j, int cost) {
        if(i >= m || j >= n) return Integer.MIN_VALUE;

        int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

        if(newCost > k) return Integer.MIN_VALUE;

        if(i == m-1 && j == n-1) return grid[i][j];

        int down = solve(grid, k, i+1, j, newCost);
        int right = solve(grid, k, i, j+1, newCost);

        int score = Math.max(down, right);
        if(score == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return grid[i][j] + score;
    }   
}





//Memoization:
class Solution {
    int m, n;
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int[][][] dp = new int[m+1][n+1][k+1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                for(int l=0; l<=k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        int result = solve(grid, k, 0, 0, 0, dp);

        return result == Integer.MIN_VALUE ? -1 : result;
    }

    public int solve(int[][] grid, int k,int i, int j, int cost, int[][][] dp) {
        if(i >= m || j >= n) return Integer.MIN_VALUE;

        int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

        if(newCost > k) return Integer.MIN_VALUE;

        if(i == m-1 && j == n-1) return grid[i][j];

        //memoization
        if(dp[i][j][cost] != -1) return dp[i][j][cost];

        int down = solve(grid, k, i+1, j, newCost, dp);
        int right = solve(grid, k, i, j+1, newCost, dp);

        int score = Math.max(down, right);
        if(score == Integer.MIN_VALUE) return dp[i][j][cost] = Integer.MIN_VALUE;

        return dp[i][j][cost] = grid[i][j] + score;
    }   
}





//Bottom Up:
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m+1][n+1][k+1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                for(int l=0; l<=k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                for(int cost=k; cost>=0; cost--) {
                    int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

                    if(newCost > k) continue;

                    if(i == m-1 && j == n-1) dp[i][j][cost] = grid[i][j]; 
                    
                    int down = -1, right = -1;
                    if(i+1 < m) down = dp[i+1][j][newCost];
                    if(j+1 < n) right = dp[i][j+1][newCost];

                    int score = Math.max(down, right);
                    if(score != -1)  dp[i][j][cost] = grid[i][j] + score;
                }
            }
        }
        return dp[0][0][0];
    }
 
}
