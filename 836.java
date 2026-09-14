/* 
Leetcode : 836
https://leetcode.com/problems/rectangle-overlap/description/
*/



//TC: 0(1), SC:0(1)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1X1 = rec1[0],
            r1Y1 = rec1[1],
            r1X2 = rec1[2],
            r1Y2 = rec1[3];

        int r2X1 = rec2[0],
            r2Y1 = rec2[1],
            r2X2 = rec2[2],
            r2Y2 = rec2[3];

        if(r2X1 >= r1X2) return false;
        if(r2Y1 >= r1Y2) return false;
        if(r1X1 >= r2X2) return false;
        if(r2Y2 <= r1Y1) return false;

        return true;
    }

}




//TC: 0(1), SC:0(1)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0],
            y1 = rec1[1],
            x2 = rec1[2],
            y2 = rec1[3];

        int x3 = rec2[0],
            y3 = rec2[1],
            x4 = rec2[2],
            y4 = rec2[3];

        return Math.min(x2, x4) > Math.max(x1, x3) &&
            Math.min(y2, y4) > Math.max(y1, y3);
    }

}