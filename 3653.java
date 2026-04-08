/* 
Leetcode : 3653
https://leetcode.com/problems/xor-after-range-multiplication-queries-i/
*/


class Solution {
    int M = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            while(l <= r) {
                nums[l] = (int) (((long) nums[l] * v) % M);
                l += k;
            }
        }

        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}