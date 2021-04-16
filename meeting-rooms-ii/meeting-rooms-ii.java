
// Time: O(nlogn), Space: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        int result = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < minHeap.peek()) {
                minHeap.offer(intervals[i][1]);
                result++;
            } else {
                minHeap.poll();
                minHeap.offer(intervals[i][1]);
            }
        }
        
        return result;
    }
}
/*
// Time: O(nlogn), Space: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        // Use Integer so sort works
        // not sure why it doesn't work for primitive type here
        Integer[] starts = new Integer[n];
        Integer[] ends = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        // sorts ascending by default
        // wrote lambda anyways for clarity
        Arrays.sort(starts, (a, b) -> a - b);
        Arrays.sort(ends, (a, b) -> a - b);
        
        int result = 0;
        int startPointer = 0, endPointer = 0;
        while (startPointer < n) {
            if (starts[startPointer] >= ends[endPointer]) {
                result--;
                endPointer++;
            }
            
            result++;
            startPointer++;
        }
        
        return result;
    }
}
*/