/*
// Time: O(m*n)
// Space: O(m*n)
class Solution {
    private int m;
    private int n;
    
    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                liveOrDie(board, result, i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    
    private void liveOrDie(int[][] board, int[][] result, int i, int j) {
        int[][] neighbors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, 
                           {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        int neighborCount = 0;
        for (int k = 0; k < neighbors.length; k++) {
            int nextRow = neighbors[k][0] + i;
            int nextCol = neighbors[k][1] + j;
            if (boundCheck(board, nextRow, nextCol)) {
                if (board[nextRow][nextCol] == 1)
                    neighborCount++;
            }
        }
        if (board[i][j] == 1) {
            if (neighborCount < 2 || neighborCount > 3) {
                result[i][j] = 0;
            }
            if (neighborCount == 2 || neighborCount == 3) {
                result[i][j] = 1;
            }
        }
        if (board[i][j] == 0 && neighborCount == 3) {
            result[i][j] = 1;
        }
    }
    
    private boolean boundCheck(int[][] board, int nextRow, int nextCol) {
        if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n)
            return true;
        
        return false;
    }
}
*/
// Time: O(m*n)
// Space: O(1)
class Solution {
    private int m;
    private int n;
    
    public void gameOfLife(int[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                liveOrDie(board, i, j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
    
    private void liveOrDie(int[][] board, int i, int j) {
        int[][] neighbors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, 
                           {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        int neighborCount = 0;
        for (int k = 0; k < neighbors.length; k++) {
            int nextRow = neighbors[k][0] + i;
            int nextCol = neighbors[k][1] + j;
            if (boundCheck(board, nextRow, nextCol)) {
                if (Math.abs(board[nextRow][nextCol]) == 1)
                    neighborCount++;
            }
        }
        if (board[i][j] == 1) {
            if (neighborCount < 2 || neighborCount > 3) {
                board[i][j] = -1;
            }
        }
        if (board[i][j] == 0 && neighborCount == 3) {
            board[i][j] = 2;
        }
    }
    
    private boolean boundCheck(int[][] board, int nextRow, int nextCol) {
        if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n)
            return true;
        
        return false;
    }
}

