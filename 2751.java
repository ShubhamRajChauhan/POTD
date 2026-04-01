/* 
Leetcode : 2751
https://leetcode.com/problems/robot-collisions/description/
*/


class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++) indices[i] = i;
        //position = [3, 5, 2, 6] we have to put it in numberline
        //so it comes like 2, 3, 5, 6 so we have to access like that first 2 then 3 and so on..
        //to process this we have index 3 at index 0, 5 at index 1 and so on
        //so we have to sort the index so it comes like 2, 3, 5, 6 
        //so the sorted manner index is 2 at index 2 , 3 at index 0, 5 at index 1 and 6 at index 3
        //so the sorted index is [2, 0, 1, 3]
        //we did this because we need to return the updated health in the order they were given in the input 
        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));


        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        for(int currentIndex : indices) {
            if(directions.charAt(currentIndex) == 'R') { //towards right
                stack.push(currentIndex);
            } else { //towards left
                while(!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.pop();

                    if(healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(healths[i] > 0) result.add(healths[i]);
        }

        return result;
    }
}