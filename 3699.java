/* 
Leetcode : 3699
https://leetcode.com/problems/number-of-zigzag-arrays-i/
*/

//Approach 1: Recursion + Memoization
class Solution {
    int MOD = 1000000007;
    int N, M;
    int[][][] dp;

    public int zigZagArrays(int n, int l, int r) {
       N = n;
       M = r - l + 1;

       dp = new int[N+1][M+1][2];
       for(int[][] a : dp) {
        for(int[] b : a) {
            Arrays.fill(b, -1);
        }
       }
       
       long result = 0;
       for(int s = 1; s <=  M; s++) {
        //a < b > c < d ...
        result = (result + solve(1, s, true)) % MOD;
        //a > b < c > d ...
        result = (result + solve(1, s, false)) % MOD;
       } 

       return (int) result;
    }

    private int solve(int i, int prevVal, boolean increasing) {
        //base case
        if(i == N) return 1; //we reached till end of zig zag array and completed one zig zag array

        int dir = increasing ? 1 : 0;
        if(dp[i][prevVal][dir] != -1) return dp[i][prevVal][dir];

        int result = 0;
        if(increasing) {
            for(int nextVal = prevVal + 1; nextVal <= M; nextVal++) {
                result = (result + solve(i+1, nextVal, false)) % MOD;
            }
        } else {
            for(int nextVal = 1; nextVal < prevVal; nextVal++) {
                result = (result + solve(i+1, nextVal, true)) % MOD;
            }
        }

        return dp[i][prevVal][dir] = result;
    }

}







//Approach 2: Bottom Up
class Solution {
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;

        long[][][] dp = new long[N+1][M+1][2];

        //base case
        for(int prevVal = 1; prevVal <= M; prevVal++) {
            dp[N][prevVal][0] = 1;
            dp[N][prevVal][1] = 1;
        }

        for(int i = N-1; i>=0; i--) {
            for(int prevVal = 1; prevVal <= M; prevVal++) {
                
                //increasing
                for(int nextVal = prevVal + 1; nextVal <= M; nextVal++) {
                    dp[i][prevVal][1] = (dp[i][prevVal][1] + dp[i+1][nextVal][0]) % MOD;
                }

                //decreasing
                for(int nextVal = 1; nextVal < prevVal; nextVal++) {
                    dp[i][prevVal][0] = (dp[i][prevVal][0] + dp[i+1][nextVal][1]) % MOD;
                }
            }
        }
        
        long result = 0;
        for(int s = 1; s <= M; s++) {
            //a < b > c < d ...
            result = (result + dp[1][s][1]) % MOD;
            //a > b < c > d...
            result = (result + dp[1][s][0]) % MOD;
        }
        return (int) result;
            
    }

}








//Approach 3: Bottom Up + Prefix Sum
class Solution {
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;

        long[][][] dp = new long[N+1][M+1][2];

        //base case
        for(int prevVal = 1; prevVal <= M; prevVal++) {
            dp[N][prevVal][0] = 1;
            dp[N][prevVal][1] = 1;
        }

        for(int i = N-1; i>=0; i--) {

            long[] cumSum1 = new long[M+1];
            long[] cumSum0 = new long[M+1];

            for(int prevVal = 1; prevVal <= M; prevVal++) {
                cumSum0[prevVal] = (cumSum0[prevVal - 1] + dp[i+1][prevVal][0]) % MOD; //decreasing
                cumSum1[prevVal] = (cumSum1[prevVal - 1] + dp[i+1][prevVal][1]) % MOD; //increasing
            }

            for(int prevVal = 1; prevVal <= M; prevVal++) {
                dp[i][prevVal][1] = (cumSum0[M] - cumSum0[prevVal] + MOD) % MOD;
                dp[i][prevVal][0] = cumSum1[prevVal - 1];
            }
        }
        
        long result = 0;
        for(int s = 1; s <= M; s++) {
            //a < b > c < d ...
            result = (result + dp[1][s][1]) % MOD;
            //a > b < c > d...
            result = (result + dp[1][s][0]) % MOD;
        }
        return (int) result;
            
    }

}

