// n = number of rooms, e = number of keys
// Time: O(n + e)
// Space: O(n)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        
        visitRooms(rooms, visited, 0);
        
        for (boolean hasVisited : visited) {
            if (!hasVisited)
                return false;
        }
        
        return true;
    }
    
    private void visitRooms(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room]) return;
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                visitRooms(rooms, visited, key);
            }
        }
    }
}