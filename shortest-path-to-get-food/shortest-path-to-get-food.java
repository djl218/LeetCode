// m = grid.length, n = grid[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m, n;
    
    public int getFood(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    return bfs(grid, new boolean[m][n], i, j);
                }
            }
        }
        
        return -1;
    }
    
    private int bfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (grid[curr[0]][curr[1]] == '#') {
                    return steps;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = curr[0] + directions[j][0];
                    int nextY = curr[1] + directions[j][1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n
                        || visited[nextX][nextY] || grid[nextX][nextY] == 'X')
                    {
                        continue;
                    }
                    if (grid[nextX][nextY] == 'O' || grid[nextX][nextY] == '#') {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}