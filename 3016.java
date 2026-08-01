/* 
Leetcode : 3016
https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/
*/

public class Solution {
    public int minimumPushes(String word) {
        int[] mp = new int[26];

        for(char ch : word.toCharArray()) {
            mp[ch - 'a']++; 
        }

        //Descending order of frequency
        Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());

        int ans = 0;
        for(int i = 0; i < 26; i++) {
            ans += mpInteger[i] * ((i / 8) + 1);
        }
        return ans;
    }
}