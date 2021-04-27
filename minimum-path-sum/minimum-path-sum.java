/*
// Brute force recursion
// Time: O(2^(m + n))
// Space: O(m + n) for recursion stack
class Solution {
    int m, n;
    int min = Integer.MAX_VALUE;
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dfs(grid, 0, 0, 0);
        return min;
    }
    
    private void dfs(int[][] grid, int row, int col, int sum) {
        if (row >= m || col >= n) return;
        
        sum += grid[row][col];
        
        if (row == m - 1 && col == n - 1)
            min = Math.min(min, sum);
        
        dfs(grid, row + 1, col, sum);
        dfs(grid, row, col + 1, sum);         
    }
}
*/

class Solution {
    int m, n;
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
        
        int[][] memo = new int[m][n];

        return helper(grid, memo, 0, 0);
    }
    
    private int helper(int[][] grid, int[][] memo, int row, int col) {
        if (row == m - 1 && col == n - 1)
            return grid[row][col];
        
        if (memo[row][col] != 0)
            return memo[row][col];
        
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        if (row < m - 1) down = helper(grid, memo, row + 1, col);
        if (col < n - 1) right = helper(grid, memo, row, col + 1);
        
        memo[row][col] = grid[row][col] + Math.min(down, right);
        return memo[row][col];
    }
}