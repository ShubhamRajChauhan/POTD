/* 
Leetcode : 3847
https://leetcode.com/problems/find-the-score-difference-in-a-game/description/
*/


//TC: 0(n)
class Solution {
    public int scoreDifference(int[] nums) {
        int gameA = 0;
        int gameB = 0;
        boolean isActive = true;

        for(int i=0; i<nums.length; i++) {
            //toggle if number is odd
            if((nums[i] & 1) == 1) {
                isActive = !isActive;
            }

            //toggle every 6th position
            if((i+1) % 6 == 0) {
                isActive = !isActive;
            }

            if(isActive) {
                gameA += nums[i];
            } else {
                gameB += nums[i];
            }
        }
        return gameA - gameB;
    }
}