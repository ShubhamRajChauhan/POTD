/* 
Leetcode : 1382
https://leetcode.com/problems/balance-a-binary-search-tree/description/
*/


class Solution {
    private void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private TreeNode makeBalance(int left, int right, ArrayList<Integer> list) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = makeBalance(left, mid - 1, list);
        root.right = makeBalance(mid + 1, right, list);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return makeBalance(0, list.size() - 1, list);
    }
}