/* 
Leetcode : 3020
https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
*/

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int result = 0;

        //handle number 1 separately
        int ones = map.getOrDefault(1L, 0); 
        if(ones % 2 == 1) {
            result = ones;
        } else {
            result = ones - 1;
        }

        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            long num = entry.getKey();

            if(num == 1) continue;

            long curr = num;
            int length = 0;

            while(map.containsKey(curr) && map.get(curr) > 1) {
                length += 2;
                curr = curr * curr;
            }

            if(map.containsKey(curr) && map.get(curr) == 1) {
                length += 1;
            } else {
                length -= 1;
            }

            result = Math.max(result, length);
        }

        return result;
    }
}