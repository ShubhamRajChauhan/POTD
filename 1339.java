/* 
Leetcode : 1339
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum = 0; //total sum of tree
    long maxProduct = 0;

    //total sum of tree
    private long getTotalSum(TreeNode root) {
        if(root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    //maxProuct
    private long find(TreeNode root) {
        if(root == null) return 0;

        long leftSum = find(root.left);
        long rightSum = find(root.right);
        long subTreeSum = root.val + leftSum + rightSum; //S1

        long remainingSubTreeSum = totalSum - subTreeSum; //S2

        maxProduct = Math.max(maxProduct, subTreeSum*remainingSubTreeSum);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        find(root);

        return (int)(maxProduct % 1_000_000_007);
    }
}