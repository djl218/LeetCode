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

// n = preorder.length = inorder.length
// Time: O(n)
// Space: O(n)
class Solution {
    Map<Integer, Integer> inMap;
    int preIdx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        preIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        
        int rootValue = preorder[preIdx++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = helper(preorder, left, inMap.get(rootValue) - 1);
        root.right = helper(preorder, inMap.get(rootValue) + 1, right);
        return root;
    }
}