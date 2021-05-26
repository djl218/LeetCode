// Time: O(1)
// Space: O(1)
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> attackQueens = new ArrayList<>();
        char[][] grid = new char[8][8];
        for (int[] queen : queens) {
            grid[queen[0]][queen[1]] = 'Q';
        }
        
        // Go down
        for (int i = king[0]; i < 8; i++) {
            if (grid[i][king[1]] == 'Q') {
                attackQueens.add(List.of(i, king[1]));
                break;
            }
        }
        
        // Go up
        for (int i = king[0]; i >= 0; i--) {
            if (grid[i][king[1]] == 'Q') {
                attackQueens.add(List.of(i, king[1]));
                break;
            }
        }
        
        // Go right
        for (int i = king[1]; i < 8; i++) {
            if (grid[king[0]][i] == 'Q') {
                attackQueens.add(List.of(king[0], i));
                break;
            }
        }
        
        // Go left
        for (int i = king[1]; i >= 0; i--) {
            if (grid[king[0]][i] == 'Q') {
                attackQueens.add(List.of(king[0], i));
                break;
            }
        }
        
        // Up left diagonal
        for (int i = king[0], j = king[1]; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') {
                attackQueens.add(List.of(i, j));
                break;
            }
        }
        
        // Up right diagonal
        for (int i = king[0], j = king[1]; i >= 0 && j < 8; i--, j++) {
            if (grid[i][j] == 'Q') {
                attackQueens.add(List.of(i, j));
                break;
            }
        }
        
        // Down left diagonal
        for (int i = king[0], j = king[1]; i < 8 && j >= 0; i++, j--) {
            if (grid[i][j] == 'Q') {
                attackQueens.add(List.of(i, j));
                break;
            }
        }
        
        // Down right diagonal
        for (int i = king[0], j = king[1]; i < 8 && j < 8; i++, j++) {
            if (grid[i][j] == 'Q') {
                attackQueens.add(List.of(i, j));
                break;
            }
        }
        
        return attackQueens;
    }
}