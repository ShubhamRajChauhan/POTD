/* 
Leetcode : 2075
https://leetcode.com/problems/decode-the-slanted-ciphertext/description/
*/

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int columns = n / rows;

        StringBuilder ans = new StringBuilder();

        for(int col = 0; col < columns; col++) {
            for(int j = col; j < n; j += (columns + 1)) {
                ans.append(encodedText.charAt(j));
            }
        }

        //remove trailing spaces
        while(ans.length() > 0 && ans.charAt(ans.length() - 1) == ' ') ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}