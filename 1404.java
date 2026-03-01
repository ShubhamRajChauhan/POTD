/* 
Leetcode : 1404
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
*/

class Solution {
    public int numSteps(String s) {
        int operation = 0;
        int carry = 0;
        for(int i = s.length() - 1; i >= 1; i--) {
            if((s.charAt(i) - '0' + carry) % 2 == 1) { //odd
                operation += 2;
                carry = 1;
            } else {
                operation += 1;
            }
        }
        return operation + carry;
    }
}

