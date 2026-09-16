/* 
Leetcode : 1621
https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/description/
*/



//Memoization:
//TC:0(n^2 * k), SC: 0(n*k)
class Solution {
    int M = 1000000007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int k) {
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n, k, 0) % M;
    }

    int solve(int n, int k, int i) {
        if(k == 0) return 1;
        if(i >= n) return 0;

        if(dp[k][i] != -1) return dp[k][i];
        long take = 0; //start segment from ith point
        for(int j=i+1; j<n; j++) {
            take = (take + solve(n, k-1, j)) % M;
        }

        long skip = solve(n, k, i+1) % M;

        return dp[k][i] = (int) ((take + skip) % M);
    }
}








//Bottom Up:
//TC:O(n^2 * K), SC:O(n*K)
class Solution {
    int M = 1000000007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {
        //base case
        for(int i=0; i<n; i++) {
            dp[0][i] = 1;
        }

        for(int k = 1; k<=K; k++) {
            for(int i=n-1; i>=0; i--) {
                int take = 0;
                for(int j=i+1; j<n; j++) {
                    take = (take + dp[k-1][j]) % M;
                }
                int skip = dp[k][i+1] % M;

                dp[k][i] = (take + skip) % M;
            }
        }

        return dp[K][0] % M;
    }

}







//Bottom Up + Sum Precomputed:
//TC:O(n*k), SC:O(n*k)
class Solution {
    int M = 1000000007;
    int[][] dp = new int[1001][1001];

    public int numberOfSets(int n, int K) {
        //base case
        for(int i=0; i<n; i++) {
            dp[0][i] = 1;
        }

        for(int k = 1; k<=K; k++) {
            int[] prevRowSum = new int[n+1];
            //prevRowSum[x] = dp[k-1][x] + dp[k-1][x+1] + ... + dp[k-1][n-1]
            for(int x = n-1; x>=0; x--) {
                prevRowSum[x] = ((prevRowSum[x + 1] + dp[k - 1][x]) % M);
            }
            for(int i=n-1; i>=0; i--) {
                int take = prevRowSum[i+1];  //dp[k-1][i+1] + dp[k-1][i+2] ...... + dp[k-1][n-1]
                int skip = dp[k][i+1] % M;

                dp[k][i] = (take + skip) % M;
            }
        }

        return dp[K][0] % M;
    }

}