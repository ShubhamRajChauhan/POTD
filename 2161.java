/* 
Leetcode : 2161
https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
*/



//Approach 1:
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr1 = new int[nums.length];
        int left = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) {
                arr1[left++] = nums[i];
            }
        } 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == pivot) {
                arr1[left++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > pivot) {
                arr1[left++] = nums[i];
            }
        }
            

        int[] result = new int[nums.length];
        System.arraycopy(arr1, 0, result, 0, left);
        

        return result;
    }
}








//Approach 2:
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        //for original nums
        int i = 0, j= n-1;

        //for result 
        int I = 0; int J = n-1;

        while(i <  n && j >= 0) {
            if(nums[i] < pivot) {
                result[I] = nums[i];
                I++;
            }

            if(nums[j] > pivot) {
                result[J] = nums[j];
                J--;
            }

            i++;
            j--;
        }

        //from I to J fill the pivot
        while(I <= J) {
            result[I] = pivot;
            I++;
        }


        return result;
    }
}
