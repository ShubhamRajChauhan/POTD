/* 
Leetcode : 628
https://leetcode.com/problems/maximum-product-of-three-numbers/description/
*/


//Approach 1: O(nlogn)
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);  
        int n = nums.length;
        
        int product1 = nums[n-1] * nums[n-2] * nums[n-3];
        int product2 = nums[0] * nums[1] * nums[n-1];  //for negative numbers [-10 -10 -9 1 2 3]
        
        return Math.max(product1, product2);
    }
}







//Approach 2: O(n)
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums) {
            //for the largest one 
            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }

            //for the smallest one
            if(num < min1) {
                min2 = min1;
                min1 = num;
            } else if(num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}