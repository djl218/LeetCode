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
// d = tree diameter
// Time: O(n)
// Space: O(d)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result = bfs(root);
        return result;
    }
    
    private List<Integer> bfs(TreeNode root) {
        List<Integer> rights = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
                if (i == size - 1)
                    rights.add(curr.val);
            }
        }
        return rights;
    }
}