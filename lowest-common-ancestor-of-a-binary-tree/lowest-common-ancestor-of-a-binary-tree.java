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
// Time: O(n)
// Space: O(n)
class Solution {
    TreeNode LCA = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return LCA;
    }
    
    private boolean findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        
        boolean left = findLCA(node.left, p, q) ? true : false;
        boolean right = findLCA(node.right, p, q) ? true : false;
        boolean found = (node == p || node == q) ? true : false;
        
        if (left && right || left && found || right && found) {
            LCA = node;
        }
        
        return left || right || found;
    }
}
