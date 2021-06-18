// n = sticks.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int connectSticks(int[] sticks) {
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        
        while (minHeap.size() > 1) {
            int smallest = minHeap.poll();
            int nextSmallest = minHeap.poll();
            int cost = smallest + nextSmallest;
            totalCost += cost;
            minHeap.offer(cost);
        }
        
        return totalCost;
    }
}
