/* 
Leetcode : 1680
https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description/
*/


class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int M = 1_000_000_007;
        int bits = 0;
        
        for(int num = 1; num <= n; num++) {
            if((num & (num - 1)) == 0) {
                bits++;
            }
            
            result = ((result << bits) % M + num) % M;
        }
        
        return (int) result;
    }
}