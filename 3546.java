/* 
Leetcode : 3546
https://leetcode.com/problems/equal-sum-grid-partition-i/
*/


class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        long totalSum = 0;

        //total sum
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                totalSum += grid[i][j];
            }
        }

        //must be even
        if(totalSum % 2 != 0) return false;

        long half = totalSum / 2;

        //horizontal cut
        long sum = 0;
        for(int i = 0; i < r - 1; i++) {
            for(int j = 0; j < c; j++) {
                sum += grid[i][j];
            }
            if(sum == half) return true;
        }

        //vertical cut
        sum = 0;
        for(int j = 0; j < c - 1; j++) {
            for(int i = 0; i < r; i++) {
                sum += grid[i][j];
            }
            if(sum == half) return true;
        }

        return false;
    }
}