/* 
Leetcode : 3129
https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/description/
*/



//-----------------------------------Memoization----------------------------------------
class Solution {
    int M = 1_000_000_007;
    int[][][] dp = new int[201][201][2];

    int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit) {
        if(onesLeft == 0 && zerosLeft == 0) return 1;
        if(dp[onesLeft][zerosLeft][lastWasOne] != -1)
            return dp[onesLeft][zerosLeft][lastWasOne];

        int result = 0;
        if(lastWasOne == 1) { //explore 0s
            for(int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        } else { //explore 1s
            for(int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }
        return dp[onesLeft][zerosLeft][lastWasOne] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int i = 0; i < 201; i++) {
            for(int j = 0; j < 201; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int startWithOne  = solve(one, zero, 0, limit);
        int startWithZero = solve(one, zero, 1, limit);
        return (startWithOne + startWithZero) % M;
    }
}







//-----------------------------------Bottom Up----------------------------------------
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = 1_000_000_007;
        int[][][] dp = new int[one + 1][zero + 1][2];

        //Base case
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for(int zerosLeft = 0; zerosLeft <= zero; zerosLeft++) {
                if(onesLeft == 0 && zerosLeft == 0) continue;

                //if(lastWasOne == true) -> explore 0s 
                int result = 0;
                for(int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                    result = (result + dp[onesLeft][zerosLeft - len][0]) % M;
                }
                dp[onesLeft][zerosLeft][1] = result;

                //else -> explore 1s 
                result = 0;
                for(int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    result = (result + dp[onesLeft - len][zerosLeft][1]) % M;
                }
                dp[onesLeft][zerosLeft][0] = result;
            }
        }

        int startWithOne  = dp[one][zero][0]; 
        int startWithZero = dp[one][zero][1]; 
        return (startWithOne + startWithZero) % M;
    }
}