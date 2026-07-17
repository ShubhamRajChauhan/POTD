/* 
Leetcode : 3867
https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/
*/


class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int max = 0;
        int[] prefixGCD = new int[n];
        for(int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGCD);

        long sum = 0;
        for(int i=0; i<n/2; i++) {
            sum += gcd(prefixGCD[i], prefixGCD[n-1-i]);
        }

        return sum;
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}