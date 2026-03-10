/* 
Leetcode : 3130
https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii/description/
*/

class Solution {

    int M = (int)1e9 + 7;
    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[zero + 1][one + 1][2];

        //base cases
        for(int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for(int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;


        for(int i = 0; i <= zero; i++) {
            for(int j = 0; j <= one; j++) {

                if(i == 0 || j == 0) continue;

                dp[i][j][1] = (dp[i][j-1][0] + dp[i][j-1][1]) % M;
                if(j-1 >= limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j-1-limit][0] + M) % M;
                }

                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1]) % M;
                if(i-1 >= limit) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i-1-limit][j][1] + M) % M;
                }
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % M;
    }
}
