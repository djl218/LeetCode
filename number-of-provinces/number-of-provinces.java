// n = isConnected.length
// Time: O(n^2)
// Space: O(n)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinceCount = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}