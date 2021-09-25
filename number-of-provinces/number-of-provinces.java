// n = isConnected.length
// Time: O(n^2)
// Space: O(n)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinceCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }
        return provinceCount;
    }
    
    private void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (visited[j] == 0 && isConnected[i][j] == 1) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}