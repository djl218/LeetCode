// n = mat.length
// Time: O(n^2)
// Space: O(1)
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int ct = 0;
        while (ct < 4) {
            transpose(mat);
            reflect(mat);
            boolean isSame = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != target[i][j]) {
                        isSame = false;
                    }
                }
            }
            if (isSame) return true;
            ct++;
        }
        return false;
    }
    
    private void transpose(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    
    private void reflect(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }
}