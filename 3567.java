/* 
Leetcode : 3567
https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/
*/

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;          
        int n = grid[0].length;       
        
        int[][] answer = new int[m - k + 1][n - k + 1];

        for(int i = 0; i <= m - k; i++) {
            for(int j = 0; j <= n - k; j++) {
                
                TreeSet<Integer> set = new TreeSet<>();
                for(int x = i; x < i + k; x++) {
                    for(int y = j; y < j + k; y++) {
                        set.add(grid[x][y]); //insert into sorted set
                    }
                }

                int minimumDiff = Integer.MAX_VALUE;
                Integer prev = null;

                for(Integer val : set) {
                    if(prev != null) {
                        minimumDiff = Math.min(minimumDiff, Math.abs(val - prev));
                    }
                    prev = val;
                }

                answer[i][j] = (minimumDiff == Integer.MAX_VALUE) ? 0 : minimumDiff;
            }
        }

        return answer; 
    }
}