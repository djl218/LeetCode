// b = bookings.length
// Time: O(n * b)
// Space: O(n)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            
            for (int i = first; i <= last; i++) {
                result[i - 1] += seats;
            }
        }
        return result;
    }
}