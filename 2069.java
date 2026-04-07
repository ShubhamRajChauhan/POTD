/* 
Leetcode : 2069
https://leetcode.com/problems/walking-robot-simulation-ii/description/
*/

class Robot {

    int idx = 0;
    boolean move = false;
    ArrayList<int[]> position = new ArrayList<>(); //to store all boundary cell positions {x, y, dir} 
    public Robot(int width, int height) {
        //Bottom Row (left to right) -> East(0)  {x, y, dir}
        for(int x = 0; x < width; x++) {
            position.add(new int[]{x, 0, 0});
        }
        //Right Column (bottom to top) -> North(1)  {x, y, dir}
        for(int y = 1; y < height; y++) {
            position.add(new int[]{width - 1, y, 1});
        }
        //Top Row (right to left) -> West(2)  {x, y, dir}
        for(int x = width - 2; x >= 0; x--) {
            position.add(new int[]{x, height - 1, 2});
        }
        //Left Column (top to bottom) -> South(3)  {x, y, dir}
        for(int y = height - 2; y > 0; y--) {
            position.add(new int[]{0, y, 3});
        }

        //Handle corner case for (0,0) after movement
        position.get(0)[2] = 3;
    }
    
    public void step(int num) {
        move = true;
        idx = (idx + num) % position.size();
    }
    
    public int[] getPos() { //{x, y}
        return new int[]{position.get(idx)[0], position.get(idx)[1]};
    }
    
    public String getDir() {
        if(!move) return "East";

        int d = position.get(idx)[2];

        if(d == 0) return "East";
        else if(d == 1) return "North";
        else if(d == 2) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */