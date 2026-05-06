/* 
Leetcode : 61
https://leetcode.com/problems/rotating-the-box/description/
*/



class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; //rows
        int n = box[0].length; //column

        char[][] result = new char[n][m]; //n->row, m->column
        //transpose
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        //reverse each row to achieve a 90-degree rotation
        for(int i = 0; i < result.length; i++) {
            int p1 = 0, p2 = result[i].length - 1;
            while(p1 < p2) {
                char temp = result[i][p1];
                result[i][p1] = result[i][p2];
                result[i][p2] = temp;
                p1++;
                p2--;
            }
        }


        //Apply gravity
        for(int j = 0; j < m; j++) {
            int space = n - 1;
            for(int i = n - 1; i >= 0; i--) {
                if(result[i][j] == '*') {
                    space = i - 1;
                    continue;
                }

                if(result[i][j] == '#') {
                    result[i][j] = '.';
                    result[space][j] = '#';
                    space--;
                }
            }
        }

        return result;
    }

}