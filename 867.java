/* 
Leetcode : 867
https://leetcode.com/problems/transpose-matrix/?envType=problem-list-v2&envId=array
*/


class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[m][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;


       //if input is square matrix (nxn)
       /*
        int n = matrix.length;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
        */
    }
}