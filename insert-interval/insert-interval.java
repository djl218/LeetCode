/*
In the case thtat there is just overlap with one interval If NI[0] > I[i][0] then I[i][1] = NI[1]
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int[] toAdd = newInterval;
        
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > toAdd[1]) {
                result.add(toAdd);
                toAdd = intervals[i];
            } else if (intervals[i][1] >= toAdd[0]) {
                toAdd = new int[]{Math.min(intervals[i][0], toAdd[0]),
                                 Math.max(intervals[i][1], toAdd[1])};
            } else {
                result.add(intervals[i]);
            }
        }
        result.add(toAdd);
        return result.toArray(new int[result.size()][2]);
    }
}