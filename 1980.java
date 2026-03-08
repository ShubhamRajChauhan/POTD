/* 
Leetcode : 1980
https://leetcode.com/problems/find-unique-binary-string/description/
*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            char ch = nums[i].charAt(i);
            
            result.append((ch == '0') ? '1' : '0');
        }
        
        return result.toString();
    }
}
