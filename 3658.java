/* 
Leetcode : 3658
https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/
*/


//Approach 1:
class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n*n, n*(n+1));
    }

    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}





//Approach 2:
class Solution {
    public int gcdOfOddEvenSums(int n) {
        // gcd(n*n, n*(n+1)) = n * gcd(n, n+1) = n * 1 = n
        return n;
    }

}
