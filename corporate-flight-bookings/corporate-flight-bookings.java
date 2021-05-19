// initial attempt
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

// inspired by folks on discussion board
// b = bookings.length
// Time: O(n + b)
// Space: O(n)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int booking[] : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            
            result[first - 1] += seats;
            if (last < n) result[last] += -seats;
        }
        
        for (int i = 1; i < n; i++)
            result[i] += result[i - 1];
        
        return result;
    }
}
