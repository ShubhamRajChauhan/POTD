/* 
Leetcode : 1914
https://leetcode.com/problems/cyclically-rotating-a-grid/description/
*/

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length; //row
        int n = grid[0].length; //column

        int layers = Math.min(m, n) / 2;
        for(int layer = 0; layer < layers; layer++) {
            List<Integer> nums = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            //top row: left to right
            for(int j = left; j <= right; j++) nums.add(grid[top][j]);
            //right column: top to bottom and skip corners
            for(int i = top + 1; i <= bottom - 1; i++) nums.add(grid[i][right]);
            //bottom row: right to left
            for(int j = right; j >= left; j--) nums.add(grid[bottom][j]);
            //left column: bottom to top and skip corners
            for(int i = bottom - 1; i >= top + 1; i--) nums.add(grid[i][left]);

            int length = nums.size();
            int K = k % length;

            //rotate left by K
            Collections.rotate(nums, -K);

            //-----now fill the rotated num in grid----
            int idx = 0;
            //top row: left to right
            for(int j = left; j <= right; j++) grid[top][j] = nums.get(idx++);
            //right column: top to bottom and skip corners
            for(int i = top + 1; i <= bottom - 1; i++) grid[i][right] = nums.get(idx++);
            //bottom row: right to left
            for(int j = right; j >= left; j--) grid[bottom][j] = nums.get(idx++);
            //left column: bottom to top and skip corners
            for(int i = bottom - 1; i >= top + 1; i--) grid[i][left] = nums.get(idx++);
        }

        return grid;
    }
}

