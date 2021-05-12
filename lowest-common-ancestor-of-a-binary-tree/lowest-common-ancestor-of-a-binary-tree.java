/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// n = number of nodes
// Time: O(n) - in worst case we might visit all of the nodes
// Space: O(n) - in worst case tree might be unbalanced
class Solution {
    TreeNode LCA = new TreeNode();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return LCA;
    }
    
    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        
        int left = helper(node.left, p, q) ? 1 : 0;
        int right = helper(node.right, p, q) ? 1 : 0;
        int curr = (node == p || node == q) ? 1 : 0;
        
        if (left + right + curr > 1)
            LCA = node;
        
        return left + right + curr > 0;
    }
}
