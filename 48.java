/* 
Leetcode : 48
https://leetcode.com/problems/rotate-image/description/
*/


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        //step1: transpose the given matrix
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //step2: reverse each row
        for(int i = 0; i < n; i++) {
            int p1 = 0, p2 = n - 1;
            while(p1 < p2) {
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][p2];
                matrix[i][p2] = temp;
                p1++;
                p2--;
            }
        }
    }
}

//TC:0(n/2 * n/2) + 0(n * n/2)
//SC:0(1)