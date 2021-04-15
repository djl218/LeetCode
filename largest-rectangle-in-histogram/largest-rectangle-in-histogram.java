// n = heights.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = i == n ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int popped = stack.pop();
                maxArea = Math.max(maxArea, heights[popped] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}