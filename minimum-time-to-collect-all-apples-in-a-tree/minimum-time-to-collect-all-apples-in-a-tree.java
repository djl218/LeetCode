// n = number of nodes
// Time: O(n)
// Space: O(n)
class Solution {    
    Set<Integer> visited = new HashSet<>();
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0, adj, hasApple, 0);
    }
    
    private int dfs(int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple, int baseTime) {
        if (visited.contains(parent)) {
            return 0;
        }
        visited.add(parent);
        int totalTime = 0;
        for (int child : adj.get(parent)) {
            totalTime += dfs(child, adj, hasApple, 2);
        }
        if (totalTime == 0 && !hasApple.get(parent)) {
            return 0;
        }
        return totalTime + baseTime;
    }
}