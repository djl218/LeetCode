// n = height.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int currHeight = Math.min(height[left], height[right]);
            int area = currHeight * (right - left);
            maxArea = Math.max(maxArea, area);
            
            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}