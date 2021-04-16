// n = number of cells on board
// l = word.length()
// Time: O(n*3^l)
// Space: O(l)
class Solution {
    private char[][] board;
    private boolean[][] visited;
    private int m;
    private int n;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        this.visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(int row, int col, String word, int index) {
        int[][] dir = new int[][]{{1, 0,}, {0, 1}, {-1, 0}, {0, -1}};
        if (index >= word.length()) return true;
        if (index >= word.length() || row < 0 || row >= m || col < 0 || col >= n
           || this.board[row][col] != word.charAt(index) || visited[row][col]) return false;

        boolean ret = false;
        visited[row][col] = true;
        
        for (int i = 0; i < dir.length; i++) {
            ret = backtrack(row + dir[i][0], col + dir[i][1], word, index + 1);
            if (ret) break;
        }
        visited[row][col] = false;
        return ret;
    }
}