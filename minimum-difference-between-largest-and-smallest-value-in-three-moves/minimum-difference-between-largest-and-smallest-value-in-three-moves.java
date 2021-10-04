// N = nums.length
// Time: O(N * lg4 * 2) == O(N), if N > 8;
//       O(NlogN) if N <= 8;
// Space: O(1)
class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        if (nums.length <= 8) {
            return getDiff(nums, true);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            minHeap.offer(num);
            maxHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        int[] arr = new int[8];
        for (int i = 3, j = 4; i >= 0 && j < 8; i--, j++) {
            arr[i] = maxHeap.poll();
            arr[j] = minHeap.poll();
        }
        return getDiff(arr, false);
    }
    
    private int getDiff(int[] arr, boolean needSort) {
        if (needSort) {
            Arrays.sort(arr);
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, arr[n - 4 + i] - arr[i]);
        }
        return min;
    }
}