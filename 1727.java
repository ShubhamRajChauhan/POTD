/* 
Leetcode : 1727
https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/
*/

//Approach 1
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow); //sorted in ascending 
            for(int col = 0; col < n; col++) {
                int base = n - col; //if sorted in descending then col + 1
                int height = currRow[col];
                result = Math.max(result, base*height);
            }
        }
        
        return result;
    }
}




//Approach 2
