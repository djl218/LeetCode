// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int m, n;
    boolean[][] visited;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    char[][] grid;
    
    public int getFood(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        
        int startX = 0, startY = 0;
        boolean found = false;
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    startX = i;
                    startY = j;
                    found = true;
                    break;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});
        
        int shortest = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                if (grid[x][y] == '#') {
                    return shortest;
                }
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (inBounds(nextX, nextY)) {
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            shortest++;
        }
        
        return -1;
    }
    
    private boolean inBounds(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] != 'X';
    }
}