/* 
Leetcode : 110
https://leetcode.com/problems/balanced-binary-tree/description/
*/


//for every node , height(left) - height(right) <= 1
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) { //if this return height means true, if -1 means false
        if(root == null) return 0;

        int left = height(root.left);
        if(left == -1) return -1;
        int right = height(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}