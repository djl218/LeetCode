// n = heights.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] findBuildings(int[] heights) {
        int currMax = 0;
        List<Integer> withView = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > currMax) {
                withView.add(0, i);
            }
            currMax = Math.max(currMax, heights[i]);
        }
        int[] result = new int[withView.size()];
        for (int i = 0; i < withView.size(); i++) {
            result[i] = withView.get(i);
        }
        return result;
    }
}