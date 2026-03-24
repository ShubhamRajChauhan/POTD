/* 
Leetcode : 2906
https://leetcode.com/problems/construct-product-matrix/description/
*/


class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n][m];

        long suffix = 1;
        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                result[i][j] = (int)suffix;
                suffix = (suffix * grid[i][j]) % mod;
            }
        }

        long prefix = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result[i][j] = (int)(prefix * result[i][j]) % mod;
                prefix = (prefix * grid[i][j]) % mod;
            }
        }

        return result;
    }
}