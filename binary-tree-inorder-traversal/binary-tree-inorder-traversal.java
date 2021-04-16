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
// Time: O(n)
// Space: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        getInorderList(root, result);
        return result;
    }
    
    private void getInorderList(TreeNode node, List<Integer> result) {
        if (node == null) return;
        
        getInorderList(node.left, result);
        result.add(node.val);
        getInorderList(node.right, result);
    }
}