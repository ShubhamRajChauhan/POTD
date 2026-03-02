/* 
Leetcode : 1266
https://leetcode.com/problems/minimum-time-visiting-all-points/
*/


class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int steps = 0;
        for(int i=0; i<points.length-1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            int x2 = points[i+1][0];
            int y2 = points[i+1][1];

            int dy = Math.abs(y2-y1);
            int dx = Math.abs(x2-x1);

            steps += (Math.min(dx, dy) + Math.abs(dy - dx));
        }
        return steps;
    }
}