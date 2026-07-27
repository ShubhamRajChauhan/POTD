/* 
Leetcode : 3536
https://leetcode.com/problems/maximum-product-of-two-digits/description/
*/


class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int second = 0;
        while(n > 0) {
            int x = n % 10;
            if(x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
            n /= 10;
        }
        return first * second;
    }
}