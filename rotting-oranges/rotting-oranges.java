// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m, n;
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (inBounds(grid, nextX, nextY)) {
                        queue.offer(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                    }
                }
            }
            if (queue.size() > 0) {
                minutes++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return minutes;
    }
    
    private boolean inBounds(int[][] grid, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1;
    }
}