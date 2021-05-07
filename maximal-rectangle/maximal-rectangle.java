// m = matrix.length, n = matrix[0].length
// Time: O(m * n)
// Space: O(n)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, findMax(dp));
        }
        return maxArea;
    }
    
    private int findMax(int[] heights) {
        int n = heights.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = i < n ? heights[i] : 0;
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int popped = stack.pop();
                maxArea = Math.max(maxArea, heights[popped] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return maxArea;
    }
}