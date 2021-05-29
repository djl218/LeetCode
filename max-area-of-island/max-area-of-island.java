// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int area, max = 0;
    int m, n;
    
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, visited, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        
        return max;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1)
            return;
        
        area++;
        visited[i][j] = true;
        
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
    }
}