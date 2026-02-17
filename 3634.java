/* 
Leetcode : 3634
https://leetcode.com/problems/minimum-removals-to-balance-array/description/
*/

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int length = 1;
        int i = 0;
        int j = 0;

        while(j < n) {
            int minEl = nums[i];
            int maxEl = nums[j];

            while(i < j && maxEl  > (long)k * minEl) {
                i++;
                minEl = nums[i];
            }

            length = Math.max(length, j-i+1);
            j++;
        }

        return n - length;
    }
}