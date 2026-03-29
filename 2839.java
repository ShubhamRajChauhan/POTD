/* 
Leetcode : 2839
https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/
*/


//Approach 1 : 
//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int evenIdx[] = new int[26];
        int oddIdx[] = new int[26];

        for(int i=0; i<4; i++) {
            if(i % 2 == 0) { //even idx
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




//Approach 2 :
//T.C : O(1)
//S.C : O(1)
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        //index 0 and 2
        boolean conditionOne = 
            (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        //index 1 and 3
        boolean conditionTwo = 
            (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
            (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return conditionOne && conditionTwo;
    }
}