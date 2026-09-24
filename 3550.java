/* 
Leetcode : 3550
https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/
*/

class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(digitSum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    public int digitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10);
            n = n / 10;
        }
        return sum;
    }
}