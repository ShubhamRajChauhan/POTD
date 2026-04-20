/* 
Leetcode : 2390
https://leetcode.com/problems/removing-stars-from-a-string/description/
*/

//Approach : 1
class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '*') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : st) sb.append(ch);

        return sb.toString();
    }
}




//Approach: 2
class Solution {
    public String removeStars(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}