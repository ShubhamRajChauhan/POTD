/* 
Leetcode : 1009
https://leetcode.com/problems/complement-of-base-10-integer/description/
*/

class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) {
            return 1;
        }
        int numberOfBits = (int)(Math.log(n) / Math.log(2)) + 1;
        int bitMask = (1 << numberOfBits) - 1; 
        return n ^ bitMask;
    }
}