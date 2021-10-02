// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int[][] res = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
                if (idx == len) {
                    if (i == m - 1 && j == n - 1) {
                        return res;
                    } else {
                        return new int[0][0];
                    }
                }
            }
        }
        return new int[0][0];
    }
}