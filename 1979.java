/* 
Leetcode : 1979
https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/
*/


class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}