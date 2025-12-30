/* 
Leetcode : 840
https://leetcode.com/problems/magic-squares-in-grid/description/?envType=daily-question&envId=2025-12-30


*/


class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int n = grid.length , m = grid[0].length, count = 0;
        for(int i=0; i<n-2; i++) {
            for(int j=0; j<m-2; j++) {
                if(distinct(i, j, grid) && rowSum(i, j, grid) && colSum(i, j, grid) && diagonalSum(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }


    private boolean rowSum(int startRow, int startCol, int[][] grid) {
        for(int i=startRow; i<startRow+3; i++) {
            int rowSum = grid[i][startCol] + grid[i][startCol+1] + grid[i][startCol+2];
            if(rowSum != 15) {
                return false;
            }
        }
        return true;
    }

    private boolean colSum(int startRow, int startCol, int[][] grid) {
        for(int j=startCol; j<startCol+3; j++) {
            int colSum = grid[startRow][j] + grid[startRow+1][j] + grid[startRow+2][j];
            if(colSum != 15) {
                return false;
            }
        }
        return true;
    }

    private boolean diagonalSum(int startRow, int startCol, int[][] grid) {
        int firstDiagonalSum = grid[startRow][startCol] + grid[startRow+1][startCol+1] + grid[startRow+2][startCol+2]; //top-left to bottom-right
        int secondDiagonalSum = grid[startRow][startCol+2] + grid[startRow+1][startCol+1] + grid[startRow+2][startCol]; //top-right to bottom-left

        return firstDiagonalSum == 15 && secondDiagonalSum == 15;
    }


    private boolean distinct(int startRow, int startCol, int[][] grid) {
        boolean[] distinctNumber = new boolean[10];
        for(int i = startRow; i<startRow + 3; i++) {
            for(int j=startCol; j<startCol + 3; j++) {
                int num = grid[i][j];
                if(num < 1 || num > 9) {
                    return false;
                }

                if(distinctNumber[num]) {
                    return false;
                } else {
                    distinctNumber[num] = true;
                }
            }
        }

        for(int i=1; i<=9; i++) {
            if(!distinctNumber[i]) {
                return false;
            }
        }
        return true;
    }
}