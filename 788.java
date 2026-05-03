/* 
Leetcode : 788
https://leetcode.com/problems/rotated-digits/
*/


class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(isValid(i)) count++;
        }
        return count;
    }

    public boolean isValid(int num) {
        boolean canChange = false;
        while(num > 0) {
            int d = num % 10;
            if(d == 3 || d == 4 || d == 7) return false;
            if(d == 2 || d == 5 || d == 6 || d == 9) canChange = true;
            num /= 10;
        }
        return canChange;
    }
}