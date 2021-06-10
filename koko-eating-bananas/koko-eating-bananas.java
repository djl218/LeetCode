// n = number of piles, w = max size of a pile
// Time: O(n log w)
// Space: O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = Arrays.stream(piles).max().getAsInt();
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (possible(piles, h, mid))
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }
    
    public boolean possible(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += pile / k;
            if (pile % k > 0) time++;
        }
        return time <= h;
    }
}