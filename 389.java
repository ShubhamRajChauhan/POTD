/* 
Leetcode : 389
https://leetcode.com/problems/find-the-difference/description/
*/




//Approach 1:
class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] freq = new int[26];

        //increment frequency for each character in string t
        for(int i = 0; i < t.length(); i++) freq[t.charAt(i) - 'a']++;

        //decrement frequency for each character in string s
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']--;

        
        for(int i = 0; i < 26; i++) {
            if(freq[i] == 1) {
                return (char) (i + 'a');
            }
        }

        return '0';
    }
}





//Approach 2: using xor
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for(char ch : s.toCharArray()) {
            result ^= ch;
        }

        for(char ch : t.toCharArray()) {
            result ^= ch;
        }

        return result;
    }
}