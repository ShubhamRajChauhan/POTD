/* 
Leetcode : 1464
https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
*/



//TC: 0(n), SC:0(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int largest = nums[0];
        int slargest = -1;

        for(int i=1; i<n; i++) {
            if(nums[i] > largest) {
                slargest = largest;
                largest = nums[i]; 
            } else if (nums[i] > slargest) {
                slargest = nums[i];
            }
        }

        return (largest - 1) * (slargest - 1);
    }
}