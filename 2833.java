/* 
Leetcode : 2833
https://leetcode.com/problems/furthest-point-from-origin/
*/

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, dash = 0;
        for(int i=0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'L') {
                left++;
            } else if(moves.charAt(i) == 'R') {
                right++;
            } else {
                dash++;
            }
        }

        return Math.max(right + dash - left, left + dash - right);
    }
}