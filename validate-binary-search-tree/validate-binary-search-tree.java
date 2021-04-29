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
    List<Integer> inOrder = new ArrayList<>();
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        helper(root);
        
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i) <= inOrder.get(i - 1))
                return false;
        }
        
        return true;
    }
    
    private void helper(TreeNode node) {
        if (node == null) return;
        
        helper(node.left);
        inOrder.add(node.val);
        helper(node.right);
    }
}

// n = number of nodes
// h = height of tree
// Time: O(n)
// Space: O(h) but possible O(n) if all nodes are on one side
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val >= max) return false;
        if (node.val <= min) return false;
        
        boolean left = helper(node.left, min, node.val);
        boolean right = helper(node.right, node.val, max);
        
        return left && right;
    }
}
