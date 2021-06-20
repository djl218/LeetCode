// m = grid1.length = grid2.length
// n = grid1[0].length = grid2[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int m, n;
    boolean isSub = true;
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        boolean[][] island = new boolean[m][n];
        
        int subCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 1 && !island[i][j]) {
                    dfs1(grid1, island, i, j);
                }
            }
        }
        
        boolean[][] island2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !island2[i][j]) {
                    isSub = true;
                    dfs2(grid2, island, island2, i, j);
                    if (isSub) subCount++;
                }
            }
        }
        
        return subCount;
    }
    
    private void dfs1(int[][] grid1, boolean[][] island, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid1[i][j] == 0 || island[i][j]) {
            return;
        }
        island[i][j] = true;
        dfs1(grid1, island, i + 1, j);
        dfs1(grid1, island, i, j + 1);
        dfs1(grid1, island, i - 1, j);
        dfs1(grid1, island, i, j - 1);
    }
    
    private void dfs2(int[][] grid2, boolean[][] island, boolean[][] island2, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || island2[i][j]) {
            return;
        }
        if (!island[i][j]) {
            isSub = false;
            return;
        }
        island2[i][j] = true;
        dfs2(grid2, island, island2, i + 1, j);
        dfs2(grid2, island, island2, i, j + 1);
        dfs2(grid2, island, island2, i - 1, j);
        dfs2(grid2, island, island2, i, j - 1);
    }
}