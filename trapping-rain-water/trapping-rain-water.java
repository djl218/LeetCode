// n = height.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0, max = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
            }
            else {
                int popped = stack.pop();
                if (!stack.isEmpty()) {
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    result += (minHeight - height[popped]) * (i - stack.peek() - 1);
                }
                i--;
            }
        }
        return result;
    }
}