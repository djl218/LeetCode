// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
                maxHeap.poll();
            }
        }
        
        int[] mins = new int[4];
        int[] maxes = new int[4];
        for (int i = 0, j = 3; i < 4; i++, j--) {
            mins[i] = minHeap.poll();
            maxes[j] = maxHeap.poll();
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, Math.abs(maxes[i] - mins[i]));
        }
        
        return minDiff;
    }
}