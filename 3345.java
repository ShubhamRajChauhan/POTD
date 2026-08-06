/* 
Leetcode : 3345
https://leetcode.com/problems/smallest-divisible-digit-product-i/description/
*/



class Solution {
    public int smallestNumber(int n, int t) {
        while(product(n) % t != 0) {
            n++;
        }
        return n;
    }

    private int product(int n) {
        int p = 1;
        while(n != 0) {
            p = p * (n % 10);
            n = n / 10;
        }
        return p;
    }
}