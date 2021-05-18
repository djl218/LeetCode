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

// n = s.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public TreeNode str2tree(String s) {
        int n = s.length();
        if (n == 0) return null;
        
        TreeNode root = new TreeNode();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        int i = 0;
        boolean isNeg = false;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '-') {
                isNeg = true;
                i++;
            } else if (c == '(') {
                if (stack.peek().left == null) {
                    stack.peek().left = new TreeNode();
                    stack.push(stack.peek().left);
                } else {
                    stack.peek().right = new TreeNode();
                    stack.push(stack.peek().right);
                }
                i++;
            } else if (c == ')') {
                stack.pop();
                i++;
            } else if (Character.isDigit(c)) {
                int currNum = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currNum = currNum * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (isNeg) currNum *= -1;
                stack.peek().val = currNum;
                isNeg = false;
            }
        }
        
        return root;
    }
}