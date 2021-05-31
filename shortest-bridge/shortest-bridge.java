// n = grid.length, n = grid[0].length
// Time: O(n^2)
// Space: O(n^2)
class Solution {
    int n;
    int[][] grid;
    boolean[][] visited;
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    Queue<int[]> queue = new LinkedList<>();
    
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    return bfs();
                }
            }
        }
        
        return -1;
    }
    
    private void dfs(int x, int y) {
        if (!inBounds(x, y)) return;
        if (grid[x][y] == 0) return;

        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        for (int[] d : dir) {
            int nextX = d[0] + x;
            int nextY = d[1] + y;
            dfs(nextX, nextY);
        }
    }
    
    private int bfs() {
        int minFlips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int nextX = d[0] + curr[0];
                    int nextY = d[1] + curr[1];
                    if (inBounds(nextX, nextY)) {
                        if (grid[nextX][nextY] == 1) {
                            return minFlips;
                        }
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            minFlips++;
        }
        
        return -1;
    }
    
    private boolean inBounds(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n
            && !visited[x][y];
    }
}