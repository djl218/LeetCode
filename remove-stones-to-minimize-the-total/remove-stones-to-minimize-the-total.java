// n = piles.length
// Time: O(n log k)
// Space: O(k)
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int stoneCount = 0;
        for (int pile : piles) {
            stoneCount += pile;
            minHeap.offer(pile);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        while(!minHeap.isEmpty()) {
            maxHeap.offer(minHeap.poll());
        }

        while (k-- > 0) {
            int pile = maxHeap.poll();
            int toRemove = (int) Math.floor(pile / 2);
            stoneCount -= toRemove;
            pile -= toRemove;
            maxHeap.offer(pile);
        }
        
        return stoneCount;
    }
}