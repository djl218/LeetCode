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

// n = number of nodes
// Time: O(n)
// Space: O(n)
class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode node) {
       if (node == null) return 0;
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
    }   
}