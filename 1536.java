/* 
Leetcode : 1536
https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/
*/

class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n]; //count of consecutive 0s from the end of ith row

        for(int i=0; i<n; i++) { 
            int count = 0;
            int j = n-1; //to start from end
            while(j >= 0 && grid[i][j] == 0) {
                count++;
                j--;
            }
            trailingZeros[i] = count;
        }

        int swaps = 0;
        for(int i=0; i<n; i++) {
            int need = n-i-1;
            int j = i;
            while(j < n && trailingZeros[j] < need) {
                j++;
            }

            if(j == n) {
                return -1;
            }

            swaps += j-i;

            while(j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                j--;
            }
        }
        return swaps;
    }
}