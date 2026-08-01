/* 
Leetcode : 3014
https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/
*/



//Approach 1:
public class Solution {
    public int minimumPushes(String word) {
        if(word.length() <= 8) return word.length();

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int assign = 2;
        for(char ch : word.toCharArray()) {
            if(assign > 9) {
                assign = 2;
            }

            map.put(assign, map.getOrDefault(assign, 0) + 1);
            count += map.get(assign);
            assign++;
        }

        return count;
    }
}







//Approach 2:
class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += i / 8 + 1;
        }
        return ans;
    }
}