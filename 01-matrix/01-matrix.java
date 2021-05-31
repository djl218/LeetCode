// m = mat.length, n = mat[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    private int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    result[i][j] = bfs(mat, i, j);
                }
            }
        }
        
        return result;
    }
    
    private int bfs(int[][] mat, int x, int y) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (mat[curr[0]][curr[1]] == 0)
                    return dist;
                
                for (int[] d : dir) {
                    int nextX = d[0] + curr[0];
                    int nextY = d[1] + curr[1];
                    if (isValid(mat, visited, nextX, nextY)) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            dist++;
        }
        
        return -1;
    }
    
    private boolean isValid(int[][] mat, boolean[][] visited, int i, int j) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length
            && !visited[i][j];
    }
}