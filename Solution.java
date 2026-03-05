/* 
Leetcode : 1758
https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/
*/

public class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int beginWithZero = 0;

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '1') {
                    beginWithZero++;
                }
            } else {
                if(s.charAt(i) == '0') {
                    beginWithZero++;
                }
            }
        }

        return Math.min(beginWithZero, n - beginWithZero);
    }
}