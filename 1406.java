/* 
Leetcode : 1406
https://leetcode.com/problems/stone-game-iii/description/
*/


//Recursion + Memoization
class Solution {
    int n;
    int[] dp;

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        int diff = solve(stoneValue, 0);

        if(diff < 0) 
            return "Bob";
        else if (diff > 0) 
            return "Alice";
        
        return "Tie";
    }

    private int solve(int[] stoneValue, int i) {
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = stoneValue[i] - solve(stoneValue, i+1);

        if(i+1 < n) {
            dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - solve(stoneValue, i+2));
        }

        if(i+2 < n) {
            dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] +  stoneValue[i + 2] - solve(stoneValue, i+3));
        }

        return dp[i];
    }
}









//Bottom Up
class Solution {
    int n;
    int[] dp;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        
        for(int i=n-1; i>=0; i--) {
            dp[i] = stoneValue[i] - dp[i+1];

            if(i+2 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] - dp[i+2]);

            if(i+3 <= n)
                dp[i] = Math.max(dp[i], stoneValue[i] + stoneValue[i + 1] +  stoneValue[i + 2] - dp[i+3]);
        }

        int diff = dp[0];

        if(diff < 0) 
            return "Bob";
        else if (diff > 0) 
            return "Alice";
        
        return "Tie";
    }
}
