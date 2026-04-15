/* 
Leetcode : 2515
https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/
*/

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(words[i].equals(target)) {
                int normalDist = Math.abs(i - startIndex);
                int circularDist = n - normalDist;

                result = Math.min(result, Math.min(normalDist, circularDist));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}