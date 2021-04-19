class Solution {
    int[] dir = new int[]{0, 1, 0, -1, 0};
    
    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    fill(grid, i, j);
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    fill(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    private void fill(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1)
            return;
        grid[r][c] = 1;
        for (int i = 0; i < dir.length - 1; i++) {
            fill(grid, r + dir[i], c + dir[i+1]);
        }
    }
}