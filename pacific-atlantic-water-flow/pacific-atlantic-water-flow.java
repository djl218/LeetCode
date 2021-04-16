// Time: O(m*n)
// Space: O(m*n)
class Solution {
    private final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0},
                                                 {0, -1}, {-1, 0}};
    int[][] matrix;
    int m, n;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] flowsToPacific = new boolean[m][n];
        boolean[][] flowsToAtlantic = new boolean[m][n];
        
        // top to bottom
        for (int i = 0; i < m; i++) {
            // left border
            pacificQueue.offer(new int[]{i, 0});
            // right border
            atlanticQueue.offer(new int[]{i, n - 1});
        }
        
        // Left to right
        for (int i = 0; i < n; i++) {
            // top border
            pacificQueue.offer(new int[]{0, i});
            // bottom border
            atlanticQueue.offer(new int[]{m - 1, i});
        }
        
        bfs(pacificQueue, flowsToPacific);
        bfs(atlanticQueue, flowsToAtlantic);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flowsToPacific[i][j] && flowsToAtlantic[i][j])
                    result.add(List.of(i, j));
            }
        }
        
        return result;
    }
    
    private void bfs(Queue<int[]> oceanQueue, boolean[][] ableToFlow) {
        while (!oceanQueue.isEmpty()) {
            int[] curr = oceanQueue.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            ableToFlow[currRow][currCol] = true;
            for (int[] dir : DIRECTIONS) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                
                if (inBounds(nextRow, nextCol) && !ableToFlow[nextRow][nextCol]) {
                    if (matrix[nextRow][nextCol] >= matrix[currRow][currCol]) {
                        ableToFlow[nextRow][nextCol] = true;
                        oceanQueue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }
    
    private boolean inBounds(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}