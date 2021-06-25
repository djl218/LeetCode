// n = number of nodes, e = number of edges
// Time: O(n + e)
// Space: O(n)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!canColor(colors, graph, i, 0))
                    return false;
            }
        }
            
        return true;
    }
    
    private boolean canColor(int[] colors, int[][] graph, int u, int color) {
        if (colors[u] != -1) {
            return colors[u] == color;
        }
        
        colors[u] = color;
        
        for (int v : graph[u]) {
            if (!canColor(colors, graph, v, color^1))
                return false;
        }
        
        return true;
    }
}