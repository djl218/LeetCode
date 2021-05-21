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

// n = post.length = pre.length
// Time: O(n)
// Space: O(n)
class Solution {
    Map<Integer, Integer> postMap = new HashMap<>();
    int preIdx = 0;
    int n;
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        n = post.length;
        for (int i = 0; i < n; i++) {
            postMap.put(post[i], i);
        }
        return helper(pre, 0, n - 1);
    }
    
    private TreeNode helper(int[] pre, int left, int right) {
        if (left > right) return null;
        
        TreeNode node = new TreeNode(pre[preIdx++]);
        if (left == right) return node;
        
        int mid = postMap.get(pre[preIdx]);
        node.left = helper(pre, left, mid);
        node.right = helper(pre, mid + 1, right - 1);
        
        return node;
    }
}

/*
    Couldn't figure out was wrong for the longest time.  Originally had this:
    
    node.left = helper(pre, left, postMap.get(pre[preIdx]));
    node.right = helper(pre, postMap.get(pre[preIdx]) + 1, right - 1);
    
    I was getting index out of bounds error. It is because preIdx is a global variable
    and its value is updated when helper is called for node.left before helper is called
    for node.right. This causes error.  Must create the mid variable to avoid this 
    race condition.  Mucho importante.
*/