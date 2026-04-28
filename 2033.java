/* 
Leetcode : 2033
https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
*/


class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }
        
        int k = list.size();
        Collections.sort(list);

        int target = list.get(k / 2);
        
        int result = 0;
        for(int num : list) {
            if(num % x != target % x) {
                return -1;
            }
            result += Math.abs(target - num) / x;
        }
        
        return result;
    }
}