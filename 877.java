/* 
Leetcode : 877
https://leetcode.com/problems/stone-game/description/
*/


//Recursion + Memoization
class Solution {
    int n;
    int[][] dp = new int[501][501];

    public boolean stoneGame(int[] piles) {
        n = piles.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                dp[i][j] = -1;
            }
        }


        int sum = 0;
        for(int p : piles) sum += p;

        int aliceScore = solve(piles, 0, n-1);

        return aliceScore > sum/2;
    }

    private int solve(int[] piles, int i, int j) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int take_i = piles[i] + Math.min(solve(piles, i+2, j), solve(piles, i+1, j-1));
        int take_j = piles[j] + Math.min(solve(piles, i, j-2), solve(piles, i+1, j-1));

        return dp[i][j] = Math.max(take_i, take_j);
    }
}





//TC:0(1), SC:0(1)
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }

}