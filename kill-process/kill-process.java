// n = pid.size = ppid.size
// Time: O(n)
// Space: O(n)
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(ppid.get(i), new ArrayList<>());
            adj.get(ppid.get(i)).add(pid.get(i));
        }
        dfs(kill, adj);
        return result;
    }
    
    private void dfs(int parent, Map<Integer, List<Integer>> adj) {
        result.add(parent);
        if (!adj.containsKey(parent)) {
            return;
        }
        for (int child : adj.get(parent)) {
            dfs(child, adj);
        }
    }
}