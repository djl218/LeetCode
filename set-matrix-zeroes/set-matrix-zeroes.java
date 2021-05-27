// m = matrix.length, n = matrix[0].length
// Time: O(m * n)
// Space: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean zeroInRow1 = false;
        boolean zeroInCol1 = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) zeroInRow1 = true;
                    if (j == 0) zeroInCol1 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (zeroInRow1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (zeroInCol1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}