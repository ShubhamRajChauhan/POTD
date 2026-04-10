/* 
Leetcode : 3741
https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/
*/


//Approach 1:
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        boolean hasTriplet = false;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k= j+1; k<n; k++) {
                    if(nums[i] == nums[j] && nums[j] == nums[k]) {
                        hasTriplet = true;
                        int totalDist = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i); //or 2 * Math.abs(k - i);
                        if(totalDist < minDist) minDist = totalDist;
                    }
                }
            }
        }
        return hasTriplet ? minDist : -1;
    }
}





//Approach 2:
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for(int k = 0; k < n; k++) {
            map.putIfAbsent(nums[k], new ArrayList<>());
            map.get(nums[k]).add(k);

            if(map.get(nums[k]).size() >= 3) {
                List<Integer> list = map.get(nums[k]);
                int size = list.size();
                int i = list.get(size - 3);
                result = Math.min(result, 2*(k - i));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}