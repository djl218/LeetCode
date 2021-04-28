// Topological Sort
// Time and space complexity is O(numCourses + prerequisites.length)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        
        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); 
        // adjacency list
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        
        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            // make sure to correctly identify the parent and the child
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            // put the child into it's parent's list
            graph.get(parent).add(child);
            // increment child's inDegree
            inDegree.put(child, inDegree.get(child) + 1);
        }
        
        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        
        // d. For each source, add it to the sortedOrder and subtract one 
        // from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        return sortedOrder.size() == numCourses;
    }
}
