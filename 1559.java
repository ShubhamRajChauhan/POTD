/* 
Leetcode : 1559
https://leetcode.com/problems/detect-cycles-in-2d-grid/description/
*/


//DFS:
class Solution {
    int m, n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && cycleDFS(i, j, i, j, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public boolean cycleDFS(int i, int j, int prev_i, int prev_j, char[][] grid, boolean[][] visited) {
        if(visited[i][j]) return true;

        visited[i][j] = true;

        for(int[] d : dir) {
            int new_i = i + d[0];
            int new_j = j + d[1];

            if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n 
                && grid[new_i][new_j] == grid[i][j]) {
                    if(new_i == prev_i && new_j == prev_j) continue;
                    if(cycleDFS(new_i, new_j, i, j, grid, visited)) {
                        return true;
                    }
            }
        }
        return false;
    }
     
}






//BFS:
class Solution {
    int m, n;
    int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && cycleBFS(i, j, grid, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cycleBFS(int i, int j, char[][] grid, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        //{i, j, prev_i, prev_j}
        q.offer(new int[]{i, j, -1, -1});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int curr_i = curr[0];
            int curr_j = curr[1];
            int prev_i = curr[2];
            int prev_j = curr[3];

            for(int[] d: dir) {
                int new_i = curr_i + d[0];
                int new_j = curr_j + d[1];

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n 
                    && grid[new_i][new_j] == grid[curr_i][curr_j]) {
                        if(new_i == prev_i && new_j == prev_j) continue;
                        if(visited[new_i][new_j]) return true;
                        visited[new_i][new_j]= true;
                        q.offer(new int[]{new_i, new_j, curr_i, curr_j});
                    }
            }
        }
        return false;
    }
     
}