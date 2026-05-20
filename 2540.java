/* 
Leetcode : 2540
https://leetcode.com/problems/minimum-common-value/description/
*/



//Approach 1: TC:0(m+n), SC:0(m)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums1) set.add(num);

        for(int num: nums2) {
            if(set.contains(num)) return num;
        }

        return -1;
    }
}







//Approach 2: TC:0(mlogn), SC:0(1) -> Binary Search
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for(int num: nums1) {
            if(binarySearch(nums2, num)) return num;
        }

        return -1;
    }

    public boolean binarySearch(int[] nums2, int target) {
        int left = 0, right = nums2.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums2[mid] == target) {
                return true;
            } else if(nums2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}








//Approach 3: TC:0(m+n), SC:0(1) -> Two Pointer
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0; //for nums1
        int j = 0; //for nums2

        while(i < n && j < m) {
            if(nums1[i] == nums2[j]) {
                return nums1[i];
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}

