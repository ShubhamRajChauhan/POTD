/* 
Leetcode : 1358
https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
*/


class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int result = 0;
        int[] map = new int[3]; // 0 - a, 1 - b, 2 - c
        
        int i = 0, j = 0;
        while(j < n) {
            char ch = s.charAt(j);
            map[ch - 'a']++;
            
            while(map[0] > 0 && map[1] > 0 && map[2] > 0) {
                result += (n - j);
                map[s.charAt(i) - 'a']--;
                i++;
            }
            
            j++;
        }
        
        return result;
    }
}