// m = rooms.length, n = rooms[0].length
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dir) {
                    int nextX = curr[0] + d[0];
                    int nextY = curr[1] + d[1];
                    
                    if (!inBounds(rooms, nextX, nextY))
                        continue;
                    
                    if (dist < rooms[nextX][nextY]) {
                        rooms[nextX][nextY] = dist;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            dist++;
        }
    }
    
    private boolean inBounds(int[][] rooms, int i, int j) {
        return i >= 0 && i < rooms.length && j >= 0
            && j < rooms[0].length && rooms[i][j] != -1
            && rooms[i][j] != 0;
    }
}