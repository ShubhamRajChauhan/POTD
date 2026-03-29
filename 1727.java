/* 
Leetcode : 1727
https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/
*/

//Approach 1
//T.C : (m * nlogn)
//S.C : O(m*n)
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
*/





//Approach 2 : without modifying the given input
//T.C : (m * nlogn)
//S.C : O(m*n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        int[] prevRow = new int[n];
        
        for(int row = 0; row < m; row++) {
            int[] currRow = matrix[row].clone();
            for(int col = 0; col < n; col++) {
                if(currRow[col] != 0) {
                    currRow[col] += prevRow[col];
                }
            }
            
            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow); //sorted in ascending 
            for(int col = 0; col < n; col++) {
                int base = n - col; //if sorted in descending then col + 1
                int height = sortedRow[col];
                result = Math.max(result, base*height);
            }

            prevRow = currRow;
        }
        
        return result;
    }
}
*/





//Approach 3 : without sorting
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList<>();
        int result = 0;

        for(int row = 0; row < m; row++) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            //i will see those columns which had got heihts in prevHeights
            for(Pair<Integer, Integer> entry : prevHeights) {
                int height = entry.getKey();
                int col = entry.getValue();
                if(matrix[row][col] == 1) {
                    heights.add(new Pair<>(height + 1, col));
                    seen[col] = true;
                }
            }

            for(int col = 0; col < n; col++) {
                if(!seen[col] && matrix[row][col] == 1) {
                    heights.add(new Pair<>(1, col));
                }
            }

            for(int i = 0; i < heights.size(); i++) {
                int base = i + 1;
                int height = heights.get(i).getKey();
                result = Math.max(result, base * height);
            }

            prevHeights = heights;
        }

        return result;
    }
    
}