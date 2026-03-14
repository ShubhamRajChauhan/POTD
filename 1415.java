/* 
Leetcode : 1415
https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
*/

class Solution {
    public void solve(int n, StringBuilder curr, int[] count, int k, String[] result) {
        if(curr.length() == n) {
            count[0]++;
            if(count[0] == k) {
                result[0] = curr.toString();  //store only the k-th string
            }
            return;
        }
        
        for(char ch = 'a'; ch <= 'c'; ch++) {
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == ch) continue;
            
            //Do
            curr.append(ch);

            //Explore
            solve(n, curr, count, k, result);

            //if result is found, exit early
            if (!result[0].isEmpty()) return;

            //Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        String[] result = {""}; //using an array to pass by reference
        int[] count = {0};  //using an array to pass count by reference
        
        solve(n, curr, count, k, result);

        return result[0];
    }
}