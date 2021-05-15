// Time: O(max(x, y)^2)
// Space: O(max(x, y)^2)
class Solution {
    int[][] moves = new int[][]{{2,-1},{2,1},{1,2},{-1,2},
                               {-2,1},{-2,-1},{-1,-2},{1,-2}};
    
    public int minKnightMoves(int x, int y) {
        int steps = 0;
        boolean[][] visited = new boolean[605][605];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == x && curr[1] == y) {
                    return steps;
                }
                for (int j = 0; j < moves.length; j++) {
                    int nextX = curr[0] + moves[j][0];
                    int nextY = curr[1] + moves[j][1];
                    if (!visited[nextX + 302][nextY + 302]) {
                        visited[nextX + 302][nextY + 302] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}