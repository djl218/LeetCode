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
/*
// BRUTE FORCE
// Inorder traversal of BST returns a list
// of node values that is sorted in ascending order
class Solution {
    List<Integer> nodes = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        getList(root);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void getList(TreeNode node) {
        if (node == null) return;
        getList(node.left);
        nodes.add(node.val);
        getList(node.right);
    }
}
*/
// OPTIMAL
class Solution {
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long lo, long hi) {
        if (node == null) return true;
        if (node.val <= lo || node.val >= hi) return false;
        return helper(node.left, lo, node.val) && helper(node.right, node.val, hi);
    }
}