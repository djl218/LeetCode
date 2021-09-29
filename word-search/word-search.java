class Solution {
    boolean wordExists = false;
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int m, n;
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, word, 0, i, j);
                    if (wordExists) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private void backtrack(char[][] board, String word, int idx, int x, int y) {
        if (idx == word.length() - 1 && word.charAt(idx) == board[x][y]) {
            wordExists = true;
            return;
        }
        if (word.charAt(idx) != board[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n 
                && word.charAt(idx + 1) == board[nextX][nextY]
                && !visited[nextX][nextY]) {
                backtrack(board, word, idx + 1, nextX, nextY);
            }
        }
        visited[x][y] = false;
    }
}