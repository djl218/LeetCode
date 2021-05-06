// Time: O(max(x, y)^2)
// Space: O(max(x, y)^2)
class Solution {
    final int[][] moves = new int[][]{{2, 1}, {2, -1},
                                      {1, 2}, {-1, 2},
                                      {-2, 1}, {-2, -1},
                                      {1, -2}, {-1, -2}};
    
    public int minKnightMoves(int x, int y) {
        boolean[][] visited = new boolean[605][605];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == x && curr[1] == y) return steps;
                for (int[] move : moves) {
                    int nextX = move[0] + curr[0];
                    int nextY = move[1] + curr[1];
                    int[] next = new int[]{nextX, nextY};
                    if (Math.abs(nextX) + Math.abs(nextY) <= 300) {
                        if (!visited[nextX + 302][nextY + 302]) {
                            visited[nextX + 302][nextY + 302] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }
}