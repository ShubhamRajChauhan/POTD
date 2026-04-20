/* 
Leetcode : 908
https://leetcode.com/problems/smallest-range-i/description/?envType=problem-list-v2&envId=array
*/


//Approach 1:
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //Step 1: find min and max
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        //Step 2: simulate k steps
        while(k > 0) {
            min++;
            max--;

            if(min >= max) {
                return 0;
            }

            k--;
        }

        //Step 3: return remaining difference
        return max - min;
    }
}





//Approach 2:
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.max(0, max - min - 2*k);
    }
}



