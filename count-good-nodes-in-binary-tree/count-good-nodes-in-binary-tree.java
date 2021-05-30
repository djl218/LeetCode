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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return countGoodNodes(root, root.val);
    }
    
    private int countGoodNodes(TreeNode node, int max) {
        if (node == null) return 0;
        
        if (node.val > max) max = node.val;
        int left = countGoodNodes(node.left, max);
        int right = countGoodNodes(node.right, max);
        
        return right + left + (node.val == max ? 1 : 0);
    }
}