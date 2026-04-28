/* 
Leetcode : 1002
https://leetcode.com/problems/find-common-characters/description/
*/


class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[] common = new int[26];
        String firstWord = words[0];
        for(char ch : firstWord.toCharArray()) {
            int idx = ch - 'a'; //a=0, b=1, ......
            common[idx]++;
        }

        for(int i=1; i<n; i++) {
            int[] curr = new int[26];
            String currWord = words[i];
            for(char ch : currWord.toCharArray()) {
                int idx = ch - 'a';
                curr[idx]++;
            }
            //update common with minimum value
            for(int j=0; j<26; j++) {
                common[j] = Math.min(common[j], curr[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for(int j=0; j<26; j++) {
            if(common[j] != 0) {
                char ch = (char) (j+97); //convert to char a,b,c,....
                int count = common[j];
                while(count > 0) {
                    result.add("" + ch); //("" + ch) converts char to string -> 'a' to "a"
                    count--;
                }
            }
        }

        return result;
    }
}