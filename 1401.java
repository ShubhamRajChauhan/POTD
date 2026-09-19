/* 
Leetcode : 1401
https://leetcode.com/problems/circle-and-rectangle-overlapping/description/
*/


class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //nearest point
        int x, y;

        //x
        if(x1 > xCenter) {
            x = x1;
        } else if(x2 < xCenter) {
            x = x2;
        } else {
            x = xCenter;
        }


        //y
        if(y1 > yCenter) {
            y = y1;
        } else if(y2 < yCenter) {
            y = y2;
        } else {
            y = yCenter;
        }

        //x, y ------- xCenter, yCenter
        double d = Math.sqrt((x - xCenter)*(x - xCenter) + (y - yCenter)*(y - yCenter));

        return d <= radius;

    }
}