// resource about diagonal looping:
// https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

// Time: O(row * col)
// Space: O(1)
class Solution {
    public int longestLine(int[][] M) {
        if (M.length == 0) return 0;
        int row = M.length, col = M[0].length;
        int diagonalLinesCount = (row + col) - 1;
        int max = 0;
        
        // horizontal check
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        
        // vertical check
        for (int j = 0; j < col; j++) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                if (M[i][j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        
        //  diagonal check
        for (int line = 1; line <= diagonalLinesCount; line++) {
            int startCol = Math.max(0, line - row);
            int lineLength = Math.min(Math.min(line, col - startCol), row);

            int count = 0;
            for (int j = 0; j < lineLength; j++) {
                if (M[Math.min(row, line) - j - 1][startCol + j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        // anti-diagonal check
        for (int line = 1; line <= diagonalLinesCount; line++) {
            int startCol = col - 1 - Math.max(0, line - row);
            int lineLength = Math.min(Math.min(line, startCol), row);
            
            int count = 0;
            for (int j = 0; j < lineLength; j++) {
                if (M[Math.min(row, line) - j - 1][startCol - j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        
        return max;
    }
}