// m = maze.length, n = maze[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int m, n;
    boolean[][] visited;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        m = maze.length;
        n = maze[0].length;
        visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            if (curr[0] == destination[0] && curr[1] == destination[1])
                return true;
            
            for (int[] d : dir) {
                int nextX = curr[0];
                int nextY = curr[1];
                
                while (isValid(maze, nextX + d[0], nextY + d[1])) {
                    nextX += d[0];
                    nextY += d[1];
                }
                
                if (!visited[nextX][nextY]) 
                    queue.offer(new int[]{nextX, nextY});
            }
        }
        
        return false;
    }
    
    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
    }
}