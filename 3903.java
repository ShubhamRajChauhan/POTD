/* 
Leetcode : 3903
https://leetcode.com/problems/smallest-stable-index-i/
*/



//TC: 0(n^2) , SC: 0(1)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int maxEl = Integer.MIN_VALUE;
            int minEl = Integer.MAX_VALUE;

            for(int j=0; j<=i; j++) maxEl = Math.max(maxEl, nums[j]);
            for(int j=i; j<=n-1; j++) minEl = Math.min(minEl, nums[j]);

            if(maxEl - minEl <= k) return i;
        }
        return -1;
    }
}





//TC: 0(n) , SC: 0(n)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] min = new int[n];
        int minEl = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            minEl = Math.min(minEl, nums[i]);
            min[i] = minEl;
        }

        int maxEl = 0;
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(maxEl, nums[i]);
            if(maxEl - min[i] <= k)
                return i;
        }

        return -1;
    }
}