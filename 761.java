/* 
Leetcode : 761
https://leetcode.com/problems/special-binary-string/
*/

class Solution {

    public String solve(String s) {
        List<String> specialBinary = new ArrayList<>();

        int start = 0;
        int sum = 0;

        for(int i=0; i<s.length(); i++) {
            sum += s.charAt(i) == '1' ? 1 : -1;

            if(sum == 0) {
                String inner = s.substring(start + 1, i);
                specialBinary.add("1" +solve(inner) + "0");
                start = i + 1;
            }
        }
        Collections.sort(specialBinary, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for(String str : specialBinary) {
            result.append(str);
        }

        return result.toString();

    }

    public String makeLargestSpecial(String s) {
        return solve(s);
    }
}