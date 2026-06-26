/* 
Leetcode : 3739
https://leetcode.com/problems/count-subarrays-with-majority-element-ii/description/
*/


//Approach 1: TC:O(n^2)
/*
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long result = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = i; j < n; j++) {
                count += (nums[j] == target ? 1 : 0);
                if(count > (j-i+1)/2) {
                    result++;
                }
            }
        }
        return result;
    }
}
*/







//Approach 2:
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        int currSum = 0;
        mp.put(0, 1);

        long validLeftPoints = 0;
        long result = 0;

        for(int x : nums) {
            if(x == target) {
                int freq = 0;
                if(mp.containsKey(currSum)) {
                    freq = mp.get(currSum);
                }
                validLeftPoints += freq;
                currSum++;
            } else {
                currSum--;

                int freq = 0;
                if(mp.containsKey(currSum)) {
                    freq = mp.get(currSum);
                }
                validLeftPoints -= freq;
            }

            if(mp.containsKey(currSum)) {
                mp.put(currSum, mp.get(currSum) + 1);
            } else {
                mp.put(currSum, 1);
            }

            result += validLeftPoints;
        }

        return result;
    }
}
