/* 
Leetcode : 3300
https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/
*/


class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) {  
            int x = calculate(num);
            min = Math.min(min, x);
        } 
        return min;
    }

    private int calculate(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}