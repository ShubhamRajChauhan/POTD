/* 
Leetcode : 1970
https://leetcode.com/problems/last-day-where-you-can-still-cross/description/

*/

class Solution {
    int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length - 1;
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(stillCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean stillCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for(int i=0; i<day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for(int c = 0; c < col; c++) {
            if(grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                visited[0][c]  = true;
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if(r == row - 1)  return true;

            for(int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >=0 && nr < row && nc >=0 && nc < col && !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}