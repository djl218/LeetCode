// DFS
// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int m, n;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);       
    }
}

// BFS
// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(min(m, n))
class Solution {
    private int m, n;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int result = 0;
        if (grid == null || grid.length == 0) return result;
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(new int[]{i, j}, visited);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void bfs(int[] start, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
           int[] curr = q.poll();
            visited[curr[0]][curr[1]] = true;
            for (int i = 0; i < dir.length; i++) {
                int[] next = new int[2];
                next[0] = curr[0] + dir[i][0];
                next[1] = curr[1] + dir[i][1];
                if (inBounds(next, visited)) {
                    q.offer(next);
                    visited[next[0]][next[1]] = true;
                }        
            }
        } 
    }
    
    private boolean inBounds(int[] curr, boolean[][] visited) {
        int i = curr[0];
        int j = curr[1];        
        if (i >= 0 && i < m && j >= 0 && j < n
            && visited[i][j] == false && grid[i][j] == '1')
            return true;
        return false;
    }
}
