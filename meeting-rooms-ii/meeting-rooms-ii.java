// Both solutions have same time and space complexity
// Just two different ways to do it

// n = intervals.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);
        
        int result = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < minHeap.peek())
                result++;
            else
                minHeap.poll();
            
            minHeap.offer(intervals[i][1]);
        }
        
        return result;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length; 
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int result = 0, endPointer = 0;
        for (int start : starts) {
            if (start < ends[endPointer])
                result++;
            else
                endPointer++;
        }
        
        return result;
    }
}
