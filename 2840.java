/* 
Leetcode : 2840
https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/description/
*/

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int evenIdx[] = new int[26];
        int oddIdx[] = new int[26];
        int n = s1.length();

        //even - even = even 
        //odd - odd = even
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                evenIdx[s1.charAt(i) - 'a']++;
                evenIdx[s2.charAt(i) - 'a']--;
            } else {
                oddIdx[s1.charAt(i) - 'a']++;
                oddIdx[s2.charAt(i) - 'a']--;
            }
        }
        
        for(int i=0; i<26; i++) {
            if(evenIdx[i] != 0 || oddIdx[i] != 0) return false;
        }

        return true;
    }
}