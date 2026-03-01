/* 
Leetcode : 1689
https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
*/


class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
            if(max == 9) {
                return 9;
            }
        }
        return max;
    }
}