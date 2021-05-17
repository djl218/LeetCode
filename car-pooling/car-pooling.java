// n = trips.length
// Time: O(max(n, 1001))
// Space: O(1001) = O(1)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int passengerCount = 0;
        for (int num : timestamp) {
            passengerCount += num;
            if (passengerCount > capacity) {
                return false;
            }
        }
        return true;
    }
}