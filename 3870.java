/* 
Leetcode : 3870
https://leetcode.com/problems/count-commas-in-range/description/
*/


class Solution {
    public int countCommas(int n) {
        if(n >= 1000) {
            return (n - 1000) + 1;
        }
        return 0;
    }
}