/* 
Leetcode : 3689
https://leetcode.com/problems/maximum-total-subarray-value-i/description/
*/


class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return (long)(max - min) * k;
    }
}