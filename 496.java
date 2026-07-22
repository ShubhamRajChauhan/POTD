/* 
Leetcode : 496
https://leetcode.com/problems/next-greater-element-i/description/
*/


//TC:0(n+m) , SC:0(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] next = new int[nums2.length];

        for(int i=nums2.length -1; i>=0; i--) {
            int element = nums2[i];

            while(!st.isEmpty() && st.peek() <= element) {
                st.pop();
            }

            if(st.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = st.peek();
            }

            st.push(element);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++) {
            map.put(nums2[i], next[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}