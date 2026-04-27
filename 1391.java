/* 
Leetcode : 1391
https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/description/
*/


class Solution {
    int m, n;
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Map<Integer, int[][]> directions = new HashMap<>();
        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{-1, 0}, {1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{-1, 0}, {0, 1}});

        boolean[][] visited = new boolean[m][n];

        return dfs(grid, 0, 0, visited, directions);
    }


    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited, Map<Integer, int[][]> directions) {

        if(i == m - 1 && j == n - 1) return true;

        visited[i][j] = true;

        for(int[] dir : directions.get(grid[i][j])) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if(new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || visited[new_i][new_j]) continue;

            //check if we can come back to (i ,j) from (new_i, new_j)
            for(int[] backDir : directions.get(grid[new_i][new_j])) {
                if(new_i + backDir[0] == i && new_j + backDir[1] == j) { //if yes, then do further dfs 
                    if(dfs(grid, new_i, new_j, visited, directions)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}