/* 
Leetcode : 2574
https://leetcode.com/problems/left-and-right-sum-differences/
*/



class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int lSum = 0;
        for(int i=0; i<n; i++) {
            ans[i] = lSum;
            lSum = lSum + nums[i];
        }

        int rSum = 0;
        for(int i=n-1; i>=0; i--) {
            ans[i] = Math.abs(ans[i] - rSum);
            rSum = rSum + nums[i];
        }

        return ans;
    }
}