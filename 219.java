/* 
Leetcode : 219
https://leetcode.com/problems/contains-duplicate-ii/description/
*/


//Approach 1: Brute Force
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] == nums[j] && Math.abs(j-i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}





//Approach 2: Using map
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //{number, index}
        for(int i=0; i<nums.length; i++) {
            //check if present in map and abs(i-j) <= k
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i) <= k) {
                return true;
            } else {
                map.put(nums[i], i); //{number, index}
            }
        }
        return false;
    }
}





//Approach 3: using sliding window
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        int i=0, j=0;
        while(j < n) {
            //step: 1
            if(Math.abs(i-j) > k) { //Math.abs(i-j) <= k
                st.remove(nums[i]);
                i++; //shrink
            }

            //did we see nums[i] in past
            if(st.contains(nums[j])) return true;

            st.add(nums[j]);
            j++;
        }

        return false;
    }
}