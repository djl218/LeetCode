/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    After passing the tests and looking at the official solution,
    I realize that 'prev' might not have been the best name choice, 
    as sometimes 'prev' will sometimes not correspond to the immediately
    previous node.  Just a heads up.
*/
// n = number of nodes
// Time: O(n)
// Space: O(1)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        while (root != null) {
            if (root.val > p.val) {
                prev = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return prev;
    }
}
