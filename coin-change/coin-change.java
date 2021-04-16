// Brute force recursion
class Solution {    
    public int coinChange(int[] coins, int amount) {
        int result = getCombos(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int getCombos(int[] coins, int amount, int idx) {
        if (amount == 0) return 0;
        if (idx >= coins.length) return Integer.MAX_VALUE;
        
        int change1 = Integer.MAX_VALUE;
        if (coins[idx] <= amount) {
            int res = getCombos(coins, amount - coins[idx], idx);
            if (res != Integer.MAX_VALUE) change1 = res + 1;
        }
        
        int change2 = getCombos(coins, amount, idx + 1);
        
        return Math.min(change1, change2);
    }
}

// Top-down dynamic programming with memoization
class Solution {    
    public int coinChange(int[] coins, int amount) {
        Integer[][] memo = new Integer[coins.length][amount + 1];
        int result = getMin(coins, amount, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int getMin(int[] coins, int amount, int idx, Integer[][] memo) {
        if (amount == 0) return 0;
        if (idx >= coins.length) return Integer.MAX_VALUE;

        if (memo[idx][amount] == null) {
            int change1 = Integer.MAX_VALUE;
            if (coins[idx] <= amount) {
                int res = getMin(coins, amount - coins[idx], idx, memo);
                if (res != Integer.MAX_VALUE) change1 = res + 1;
            }
            int change2 = getMin(coins, amount, idx + 1, memo);
            memo[idx][amount] = Math.min(change1, change2);
        }
        return memo[idx][amount];    
    }
}

// Bottom-up dynamic programming
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length, n = amount + 1;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j >= coins[i] && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i]]);
                } 
            }
        }
        
        return dp[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1][n - 1];
    }
}

// Less space dynamic programming
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
