/* 
Leetcode : 2126
https://leetcode.com/problems/destroying-asteroids/submissions/2018341217/
*/


class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int m : asteroids) {
            if(mass < m){
                return false;
            } else if(mass >= 10000000){
                return true;
            }
            mass += m;
        }
        return true;
    }
}