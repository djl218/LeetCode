// Brute force recursion
// Time: O(2^(m + n))
// Space: O(m + n) for recursion stack
class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m, n);
    }
    
    private int dfs(int m, int n) {
        if (m == 1 || n == 1) return 1;
        
        int moveRight = dfs(m, n - 1);
        int moveDown = dfs(m - 1, n);
        
        return moveRight + moveDown;
    }
}

// Top-down dynamic programming with memoization
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return dfs(dp, m, n);
    }
    
    public int dfs(int[][] dp, int m, int n) {
        if (m == 1 || n == 1) return 1;
        
        if (dp[m][n] == 0) {
            int moveRight = dfs(dp, m, n - 1);
            int moveDown = dfs(dp, m - 1, n);
            
            dp[m][n] = moveRight + moveDown;
        }
        
        return dp[m][n];
    }
}

// Bottom-up dynamic programming with tabulation
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m][n];
    }
}
