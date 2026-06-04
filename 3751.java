/* 
Leetcode : 3751
https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/
*/


class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int num = num1; num <= num2; num++) {
            ans += check(num);
        }

        return ans;
    }

    private int check(int num) {
        String s = Integer.toString(num);

        int n = s.length();
        if(n < 3) return 0;

        int count = 0;
        for(int i=1; i<n-1; i++) {
            //peak
            if(s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1)) count++;
            //valley
            if(s.charAt(i) < s.charAt(i-1) && s.charAt(i) < s.charAt(i+1)) count++;
        }

        return count;
    }
}