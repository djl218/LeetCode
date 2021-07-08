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

// m = nodes in root1, n = nodes in root2
// Time: O(m + n)
// Space: O(m + n)
class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        buildSet(root1, set);
        
        return dfs(root2, set, target);
    }
    
    private void buildSet(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        
        set.add(node.val);
        buildSet(node.left, set);
        buildSet(node.right, set);
    }
    
    private boolean dfs(TreeNode node, Set<Integer> set, int target) {
        if (node == null) return false;
        
        if (set.contains(target - node.val)) {
            return true;
        }
        
        boolean left = dfs(node.left, set, target);
        boolean right = dfs(node.right, set, target);
        
        return left || right;
    }
}