// Time: O(rows * columns)
// Space: O(rows * columns)
class Solution {
    private static final int[] dirX = {0, 1, 0, -1};
    private static final int[] dirY = {1, 0, -1, 0};
        
    private boolean isValid(int nr, int nc, int[][] grid) {
        return nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1;
    }
        
    private int bfs (int i, int j, int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        int count = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            count++;
            for (int k = 0; k < dirX.length; k++) {
                int nr = current[0] + dirX[k];
                int nc = current[1] + dirY[k];
                if (isValid(nr, nc, grid)) {
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return count;
    }
        
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    max = Math.max(max, bfs(i, j, grid));
                }
            }
        }
        return max;
    }
}