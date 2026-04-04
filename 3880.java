/* 
Leetcode : 3880
https://leetcode.com/problems/minimum-absolute-difference-between-two-values/description/
*/


/*
class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int ans = 100000007;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(nums[i] == 1 && nums[j] == 2) {
                    ans = Math.min(ans, Math.abs(i - j));
                }
            }
        }
        return (ans == 100000007) ? -1 : ans;
    }
}
*/



class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int lastOne = -1;
        int lastTwo = -1;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                lastOne = i;
                if(lastTwo != -1) {
                    ans = Math.min(ans, Math.abs(lastOne - lastTwo));
                }
            }
            else if(nums[i] == 2) {
                lastTwo = i;
                if(lastOne != -1) {
                    ans = Math.min(ans, Math.abs(lastOne - lastTwo));
                }
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}