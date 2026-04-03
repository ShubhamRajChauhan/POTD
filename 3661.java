/* 
Leetcode : 3661
https://leetcode.com/problems/maximum-walls-destroyed-by-robots/
*/


class Solution {

    int[][] dp;

    int solve(int[] walls, int[][] roboDist, int[][] range, int i, int prevDir) {

        if(i == roboDist.length) return 0;

        if(dp[i][prevDir] != -1) return dp[i][prevDir];

        int leftStart = range[i][0];

        //if previous robot shot right
        if(prevDir == 1 && i > 0) {
            leftStart = Math.max(leftStart, range[i - 1][1] + 1);
        }

        //shoot left
        int leftTake = countWalls(walls, leftStart, roboDist[i][0]) +
                       solve(walls, roboDist, range, i + 1, 0);

        //shoot right
        int rightTake = countWalls(walls, roboDist[i][0], range[i][1]) +
                        solve(walls, roboDist, range, i + 1, 1);

        return dp[i][prevDir] = Math.max(leftTake, rightTake);
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = robots.length;

        //combine robots + distance
        int[][] roboDist = new int[n][2];
        for(int i = 0; i < n; i++) {
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }

        //sort by robot position
        Arrays.sort(roboDist, (a, b) -> a[0] - b[0]);

        Arrays.sort(walls);

        //prepare range for each robot
        int[][] range = new int[n][2];

        for(int i = 0; i < n; i++) {
            int pos = roboDist[i][0];
            int d = roboDist[i][1];

            int leftLimit  = (i == 0) ? 1 : roboDist[i - 1][0] + 1;
            int rightLimit = (i == n - 1) ? (int)1e9 : roboDist[i + 1][0] - 1;

            int L = Math.max(pos - d, leftLimit);
            int R = Math.min(pos + d, rightLimit);

            range[i][0] = L;
            range[i][1] = R;
        }

        dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        //prevDir = 0/1 (previous robot hit bullet to left/right)
        return solve(walls, roboDist, range, 0, 0);
    }

    //count walls in range [L, R]
    int countWalls(int[] walls, int L, int R) {
        int left = lowerBound(walls, L);
        int right = upperBound(walls, R);
        return right - left;
    }

    //binary search: first index >= target
    int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    //binary search: first index > target
    int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}