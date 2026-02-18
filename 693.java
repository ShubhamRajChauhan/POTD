/* 
Leetcode : 693
https://leetcode.com/problems/binary-number-with-alternating-bits/description/
*/


class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}



