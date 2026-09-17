/* 
Leetcode : 1477
https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/description/
*/



class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int i = 0, j = 0;
        int currSum = 0;

        int[] minBestLenTillIdx = new int[n];
        Arrays.fill(minBestLenTillIdx, Integer.MAX_VALUE);

        int bestMinLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while(j < n) {
            currSum += arr[j];

            while(i < j && currSum > target) {
                currSum -= arr[i++];
            }

            if(currSum == target) {
                int len = j-i+1;

                if(i > 0 && minBestLenTillIdx[i-1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minBestLenTillIdx[i-1]);
                }

                bestMinLen = Math.min(bestMinLen, len);
            }

            minBestLenTillIdx[j] = bestMinLen;
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}