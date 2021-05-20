// v = number of nodes
// e = edges.length
// Time: O(v + e)
// Space: O(v + e)
class Solution {
    String colors;
    Map<Integer, int[]> memo = new HashMap<>();
    Map<Integer, List<Integer>> adjList;
    int maxColorValue = 0;
    boolean cyclePresent = false;
    boolean[] visited;
    
    public int largestPathValue(String colors, int[][] edges) {
        this.colors = colors;
        int n = colors.length();
        if (edges.length == 0) return 1;
        adjList = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }
        
        for (int[] edge : edges) {           
            adjList.get(edge[0]).add(edge[1]);
            inDegrees.put(edge[1], inDegrees.get(edge[1]) + 1);
        }
        
        visited = new boolean[n];
        boolean thereIsAtLeastOneSource = false;
        for (int node : inDegrees.keySet()) {
            if (inDegrees.get(node) == 0) {
                if (adjList.get(node).size() == 0) return -1;
                thereIsAtLeastOneSource = true;
                dfs(node);
                if (cyclePresent) return -1;
            }
        }
        
        return thereIsAtLeastOneSource ? maxColorValue : -1;
    }
    
    private int[] dfs(int node) {
        if (visited[node]) {
            cyclePresent = true;
            return new int[26];
        }
        
        if (memo.get(node) != null) {
            return memo.get(node);
        }
        
        visited[node] = true;
        int[] parentPathColors = new int[26];
        
        for (int child : adjList.get(node)) {
            int[] currPathColors = dfs(child);
            if (visited[child]) continue;
            if (cyclePresent) {
                return parentPathColors;
            }
                
            for (int i = 0; i < 26; i++) {
                parentPathColors[i] = Math.max(parentPathColors[i], currPathColors[i]);
                maxColorValue = Math.max(maxColorValue, parentPathColors[i]);
            }
        }
        
        parentPathColors[colors.charAt(node) - 'a']++;
        maxColorValue = Math.max(maxColorValue, parentPathColors[colors.charAt(node) - 'a']);
        
        visited[node] = false;
        memo.put(node, parentPathColors);
        return parentPathColors;
    }
}