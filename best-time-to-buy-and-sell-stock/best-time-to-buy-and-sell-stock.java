// n = prices.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : prices) {
            max = Math.max(max, num - min);
            if (num < min) min = num;
        }
        
        return max;
    }
}