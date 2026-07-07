/* 
Leetcode : 3754
https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/
*/

class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n);

        int sum = 0;
        StringBuilder ans = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c != '0') {
                ans.append(c);
                sum += c - '0';
            }
        }

        long num = ans.length() == 0 ? 0 : Long.parseLong(ans.toString());

        return sum * num;
    }
}