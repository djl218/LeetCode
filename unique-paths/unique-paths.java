/*
// Top-down dynamic programming with memoization
// Time: O(2^(m + n))
// Space: O(m + n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return CountWaysRecursive(dp, m, n);
    }
    
    public int CountWaysRecursive(int[][] dp, int m, int n) {
        if (m == 0 || n == 0) return 1;
        if (m == 1 || n == 1) return 1;
        
        if (dp[m][n] == 0) {
            int moveRight = n > 0 ? CountWaysRecursive(dp, m, n - 1) : 0;
            int moveDown = m > 0 ? CountWaysRecursive(dp, m - 1, n) : 0;
            
            dp[m][n] = moveRight + moveDown;
        }
        
        return dp[m][n];
    }
}
*/
// Bottom-up dynamic programming with tabulation
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }
}
