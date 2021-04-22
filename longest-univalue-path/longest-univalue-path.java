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

// Time: O(N) where N is the number of nodes in tree
// Space: O(H) where H is the height of the tree
class Solution {
    int longest = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        getLongPath(root, root.val);
        return longest;
    }
    
    private int getLongPath(TreeNode node, int prev) {
        if (node == null) return 0;
        
        int left = getLongPath(node.left, node.val);
        int right = getLongPath(node.right, node.val);
        
        longest = Math.max(longest, left + right);
        
        if (prev == node.val) return Math.max(left, right) + 1;
        return 0;
    }
}