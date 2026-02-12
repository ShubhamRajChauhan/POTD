/* 
Leetcode : 3713
https://leetcode.com/problems/longezst-balanced-substring-i/description/?envType=daily-question&envId=2026-02-12
*/

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;

                if(check(freq)) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }

        return maxLength;
    }

    private boolean check(int[] freq) {
        int common = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] == 0) continue;
            if(common == 0) {
                common = freq[i];
            } else if(freq[i] != common) {
                return false;
            }
        }
        return true;
    }
    
}