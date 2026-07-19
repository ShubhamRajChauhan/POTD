/* 
Leetcode : 1081
https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
*/

class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        for(int i=0; i<s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int curr = ch - 'a';

            if(seen[curr]) continue;

            while(!stack.isEmpty() && stack.peek() > ch && i < lastIdx[stack.peek() - 'a']) {
                seen[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.push(ch);
            seen[curr] = true;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}