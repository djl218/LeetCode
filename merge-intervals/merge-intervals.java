// n = intervals.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int currStart = 0, currEnd = 0;
        boolean pastFirst = false;
        for (int i = 0; i < n; i++) {
            if (!pastFirst) {
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
                pastFirst = true;
            } else if (intervals[i][0] <= currEnd) {
                currEnd = Math.max(currEnd, intervals[i][1]);
            } else if (intervals[i][0] > currEnd) {
                merged.add(new int[]{currStart, currEnd});
                currStart = intervals[i][0];
                currEnd = Math.max(currEnd, intervals[i][1]);
            }
            if (i == n - 1) {
                merged.add(new int[]{currStart, currEnd});
            }
        }
        int resLen = merged.size();
        int[][] result = new int[resLen][2];
        for (int i = 0; i < resLen; i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
