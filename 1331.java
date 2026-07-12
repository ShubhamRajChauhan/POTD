/* 
Leetcode : 1331
https://leetcode.com/problems/rank-transform-of-an-array/description/
*/


class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for(int i=0; i<n; i++) {
            map.put(sorted[i], rank);

            while(i < n-1 && sorted[i+1] == sorted[i]) {
                map.put(sorted[i], rank);
                i++;
            }

            rank++;
        }

        for(int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}