/* 
Leetcode : 762
https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
*/

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;

        HashSet<Integer> isPrime = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        for(int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);

            if(isPrime.contains(setBits)) {
                result++;
            }
        }

        return result;
    }
}