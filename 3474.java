/* 
Leetcode : 3474
https://leetcode.com/problems/lexicographically-smallest-generated-string/
*/

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;

        char[] word = new char[N];
        //fill with placeholder
        for(int i = 0; i < N; i++) word[i] = '$';

        boolean[] canChange = new boolean[N];

        //step 1: process 'T'
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) == 'T') {
                int idx = i;
                for(int j = 0; j < m; j++) {
                    if(word[idx] != '$' && word[idx] != str2.charAt(j)) {
                        return "";
                    }
                    word[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        //step 2: fill remaining with 'a'
        for(int i = 0; i < N; i++) {
            if(word[i] == '$') {
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        //step 3: process 'F'
        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) == 'F') {

                if(isSame(word, str2, i, m)) {
                    boolean changed = false;

                    for(int k = i + m - 1; k >= i; k--) {
                        if(canChange[k]) {
                            word[k] = 'b';  
                            canChange[k] = false;
                            changed = true;
                            break;
                        }
                    }

                    if(!changed) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for(int j = 0; j < m; j++) {
            if(word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }
}
