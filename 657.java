/* 
Leetcode : 657
https://leetcode.com/problems/robot-return-to-origin/
*/


class Solution {
    public boolean judgeCircle(String moves) {
        int xAxis = 0;
        int yAxis = 0;

        for(int i=0; i<moves.length(); i++) {
            char ch = moves.charAt(i);
            if(ch == 'U') yAxis++;
            else if(ch == 'D') yAxis--;
            else if(ch == 'R') xAxis++;
            else if(ch == 'L') xAxis--;
        }

        return xAxis == 0 && yAxis == 0;
    }
}