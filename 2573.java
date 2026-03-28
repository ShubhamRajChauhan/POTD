/* 
Leetcode : 2573
https://leetcode.com/problems/find-the-string-with-lcp/description/
*/

class Solution {

    private int[][] checkLCP(String word) {
        int n = word.length();
        int[][] lcp = new int[n][n];

        //last column
        for(int i = 0; i < n; i++) {
            lcp[i][n - 1] = (word.charAt(i) == word.charAt(n - 1)) ? 1 : 0;
        }

        //last row
        for(int j = 0; j < n; j++) {
            lcp[n - 1][j] = (word.charAt(n - 1) == word.charAt(j)) ? 1 : 0;
        }

        //fill rest bottom-up
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                if(word.charAt(i) == word.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        return lcp;
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        //initialize with placeholder
        for(int i = 0; i < n; i++) word[i] = '*';

        for(int i = 0; i < n; i++) {
            //step 1: try to match with previous
            for(int j = 0; j < i; j++) {
                if(lcp[j][i] != 0) word[i] = word[j]; break;
            }   

            //step 2: assign smallest valid character
            if(word[i] == '*') {
                boolean[] notUsed = new boolean[26];

                for(int j = 0; j < i; j++) {
                    if(lcp[j][i] == 0) {
                        notUsed[word[j] - 'a'] = true;
                    }
                }

                for(int c = 0; c < 26; c++) {
                    if(!notUsed[c]) {
                        word[i] = (char) ('a' + c);
                        break;
                    }
                }

                
                if(word[i] == '*')  return ""; //we could never fill word[i]
            }
        }

        String result = new String(word);

        //final validation
        int[][] computed = checkLCP(result);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return result;
    }
}

