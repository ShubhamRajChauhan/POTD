/* 
Leetcode : 486
https://leetcode.com/problems/predict-the-winner/description/
*/


//Recursion 
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int totalScore = 0;
        for(int num : nums) totalScore += num;

        int player1Score = solve(0, n-1, nums);
        int player2Score = totalScore - player1Score;
        return player1Score >= player2Score;
    }

    private int solve(int i, int j, int[] nums) {
        if(i > j) return 0;
        if(i == j) return nums[i];

        int take_i = nums[i] + Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        int take_j = nums[j] + Math.min(solve(i, j-2, nums), solve(i+1, j-1, nums));

        return Math.max(take_i, take_j);
    }
}



//Memoization
class Solution {
    int n;
    int[][] dp = new int[23][23];
    public boolean predictTheWinner(int[] nums) {
        n = nums.length;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        int totalScore = 0;
        for(int num : nums) totalScore += num;

        int player1Score = solve(0, n-1, nums);
        int player2Score = totalScore - player1Score;
        return player1Score >= player2Score;
    }

    private int solve(int i, int j, int[] nums) {
        if(i > j) return 0;
        if(i == j) return nums[i];

        if(dp[i][j] != -1) return dp[i][j];
        int take_i = nums[i] + Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        int take_j = nums[j] + Math.min(solve(i, j-2, nums), solve(i+1, j-1, nums));

        return dp[i][j] = Math.max(take_i, take_j);
    }
}


