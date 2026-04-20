/* 
Leetcode : 2078
https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/
*/

class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i = 0;
        int j = n-1;
        
        int ans = 0;
        while(i < j) {
            if(colors[i] == colors[j]) {
                j--;
            } else {
                ans = Math.abs(i-j); break;
            }
        }

        i = 0;
        j = n-1;
        while(i < j) {
            if(colors[i] == colors[j]) {
                i++;
            } else {
                ans = Math.max(ans,Math.abs(j - i)); break;
            }
        }
        return ans;
    }
}