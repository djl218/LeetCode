// E = number of edges, V = number of vertices
// Time: O(E + V)
// Space: O(E + V)
class Solution {
    Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int count = 0;
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[1]).add(edge[0]);
        }
        visited = new HashSet<>();
        for (int node : adj.keySet()) {
            System.out.println(node);
            if (!visited.contains(node)) {
                count++;
                dfs(adj, node);
            }
        }
        return n > adj.size() ? count + (n - adj.size()) : count;
    }
    
    private void dfs(Map<Integer, List<Integer>> adj, int node) {
        visited.add(node);
        for (int nei : adj.get(node)) {
            if (!visited.contains(nei)) {
                dfs(adj, nei);
            }
        }
    }
}