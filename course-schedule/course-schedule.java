class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> inDeg = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            inDeg.put(i, 0);
            adj.put(i, new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            inDeg.put(pre[0], inDeg.get(pre[0]) + 1);
            adj.get(pre[1]).add(pre[0]);
        }
        
        Queue<Integer> sources = new LinkedList<>();
        for (int key : inDeg.keySet()) {
            if (inDeg.get(key) == 0)
                sources.offer(key);
        }
        
        List<Integer> sorted = new ArrayList<>();
        while (!sources.isEmpty()) {
            int curr = sources.poll();
            sorted.add(curr);
            for (int nei : adj.get(curr)) {
                inDeg.put(nei, inDeg.get(nei) - 1);
                if (inDeg.get(nei) == 0)
                    sources.offer(nei);
            }
        }
        System.out.print(sorted.size() + "" + numCourses);
        return sorted.size() == numCourses;
    }
}