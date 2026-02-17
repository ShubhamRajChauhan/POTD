/* 
Leetcode : 1975
https://leetcode.com/problems/maximum-matrix-sum/description/
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int negCount = 0;
        int minAbsolute = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                totalSum += Math.abs(matrix[i][j]);
                minAbsolute = Math.min(minAbsolute, Math.abs(matrix[i][j]));

                if(matrix[i][j] < 0) negCount++;
                
            }
        }

        if(negCount % 2 == 0) { // even negatives
            return totalSum;
        }

        return totalSum - 2 * minAbsolute; //odd negatives
    }
}