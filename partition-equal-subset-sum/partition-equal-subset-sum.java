// Bottom Up Dynamic Programming
// n = nums.length, s = subsetSum
// Time: O(n * s)
// Space: O(n * s)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 != 0) return false;
        
        // the target sum is the total
        // sum divided by two
        int subsetSum = sum / 2;
        
        int n = nums.length, s = subsetSum;
        boolean[][] dp = new boolean[n + 1][s + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][s];
    }
}