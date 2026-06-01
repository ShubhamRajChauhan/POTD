/* 
Leetcode : 2144
https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/description/
*/


class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int sum = 0;
        for(int num : cost) sum += num;

        for(int i = cost.length - 3; i >= 0; i -= 3) {
            sum -= cost[i];
        }

        return sum;
    }
}