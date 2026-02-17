/* 
Leetcode : 961
https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/


*/


//Approach 1: TC: 0(n) , SC: 0(n)

/*
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key: map.keySet()) {
            if(map.get(key) > 1) {
                return key;
            }
        }
        return -1;
    }
}
*/

//Approach 2: TC: 0(n^2), SC: 0(n)
/*
class Solution {
    public int repeatedNTimes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(); //SC: 0(n)
        for(int num : nums) { //TC: 0(n)
            if(list.contains(num)) return num; //TC: 0(n) -> list.contains()
            else list.add(num);
            
        }
        
        return -1;
    }
}
*/


//Approach 3: TC: 0(n), SC: 0(1)
class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=0; i<nums.length-1; i++) { 
           if(nums[i] == nums[i+1] || i + 2 < nums.length && nums[i] == nums[i+2]) {
            return nums[i];
           }
        }
        
        return nums[0];
    }
}