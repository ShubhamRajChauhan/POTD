/* 
Leetcode : 3856
https://leetcode.com/problems/trim-trailing-vowels/description/
*/


class Solution {
    public String trimTrailingVowels(String s) {
        String trim = "";
        for(int i=s.length()-1; i>=0; i--) {
            int ch = s.charAt(i);
            if(ch == 'a' ||ch == 'e' ||ch == 'i'||ch == 'o'||ch == 'u') {
                continue;
            } else {
                trim = s.substring(0, i+1);
                break;
            }
        } 
        return trim;
    }
}
