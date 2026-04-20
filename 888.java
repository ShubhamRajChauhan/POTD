/* 
Leetcode : 888
https://leetcode.com/problems/fair-candy-swap/?envType=problem-list-v2&envId=array
*/

//Approach 1:
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        int sumA = 0, sumB = 0;

        for(int num : aliceSizes) sumA += num;
        for(int num : bobSizes) sumB += num;

        for(int i=0; i<aliceSizes.length; i++) {
            for(int j=0; j<bobSizes.length; j++) {
                if(sumA - aliceSizes[i] + bobSizes[j] == sumB + aliceSizes[i] - bobSizes[j]) {
                    ans[0] = aliceSizes[i];
                    ans[1] = bobSizes[j];
                    return ans;
                }
            }
        }
        return ans;
    }
}




//Approach 2:
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sumB = 0;

        for(int num : aliceSizes) sumA += num;
        for(int num : bobSizes) {
            sumB += num; 
            set.add(num);
        }

        int finalSum = (sumB - sumA) / 2;
        for(int i=0; i<aliceSizes.length; i++) {
            int val = finalSum + aliceSizes[i];
            if(set.contains(val)) {
                ans[0] = aliceSizes[i];
                ans[1] = val;
                return ans;
            }
        }
        return ans;
    }
}