class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            adjList.put(i, new ArrayList<>());
        }
        
        // Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            inDegree.put(child, inDegree.get(child) + 1);
            adjList.get(parent).add(child);
        }
        
        Queue<Integer> queue = new LinkedList();
        for (int node : inDegree.keySet()) {
            if (inDegree.get(node) == 0)
                queue.offer(node);
        }
        
        List<Integer> sortedList = new ArrayList();
        while (!queue.isEmpty()) {
            int source = queue.poll();
            sortedList.add(source);
            for (int adj : adjList.get(source)) {
                inDegree.put(adj, inDegree.get(adj) - 1);
                if (inDegree.get(adj) == 0)
                    queue.offer(adj);
            }
        }
        
        if (sortedList.size() != numCourses) return new int[0];
        return sortedList.stream().mapToInt(i->i).toArray();
    }
}
/*
    indegree -> <vertex, #of edges coming in> (hashmap)
    graph -> <vertex, adjacency list> (hashmap)
    
    prerequisites[i][0] = child
    prerequistites[i][1] = parent
    
    1. initialize graph
    2. build graph
    3. add sources to queue
    4. poll source from queue and add to sortedOrder
    5. get that sources adjacency list
    6. for each child on that list subtract one edge from its inDegree
    7. if indegree becomes a source (value is 0), add it to the queue
    */