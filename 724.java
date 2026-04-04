/* 
Leetcode : 724
https://leetcode.com/problems/find-pivot-index/description/
*/


class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int num : nums) sum += num;

        int cumulativeSum = 0;
        for(int i=0; i<n; i++) {
            int leftSum = cumulativeSum;
            int rightSum = sum - cumulativeSum - nums[i];

            if(leftSum == rightSum) return i;

            cumulativeSum += nums[i];
        }

        return -1;
    }
}