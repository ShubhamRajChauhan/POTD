/* 
Leetcode : 2657
https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
*/



//Approach 1:
//TC: 0(n^2), SC: 0(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        boolean[] inA = new boolean[n+1];
        boolean[] inB = new boolean[n+1];

        for(int i=0; i<n; i++) {
            inA[A[i]] = true;
            inB[B[i]] = true;

            int count = 0;
            for(int num = 1; num <= n; num++) {
                if(inA[num] == true && inB[num] == true) count++;
            }

            result[i] = count;
        }

        return result;
    }
}







//Approach 2:
//TC, SC: 0(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        
        int[] result = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for(int i=0; i<n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1); //map[A[i]]++
            if(map.get(A[i]) == 2) count++;

            map.put(B[i], map.getOrDefault(B[i], 0) + 1); //map[B[i]]++
            if(map.get(B[i]) == 2) count++;

            result[i] = count;
        }

        return result;
    }
}