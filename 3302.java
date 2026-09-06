/* 
Leetcode : 3302
https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/description/
*/


class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] rightLength = new int[n+1];
        int rightMatched = 0;
        int i = n-1;
        int j = m-1;
        while(i >= 0) {
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rightMatched++;
                j--;
            }

            rightLength[i] = rightMatched;
            i--;
        }

        int[] ans = new int[m];
        int idx = 0;
        boolean changePower = true;

        i=0;
        j=0;

        while(i < n && j < m) {
            if(word1.charAt(i) == word2.charAt(j)) {
                ans[idx++] = i;
                j++;
            } else if(changePower && rightLength[i+1] >= m-j-1) {
                ans[idx++] = i;
                j++;
                changePower = false;
            }
            i++;
        }

        return j == m ? ans : new int[0];
         
    }
}