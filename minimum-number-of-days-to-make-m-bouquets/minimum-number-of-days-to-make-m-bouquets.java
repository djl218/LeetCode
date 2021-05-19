// d = maxBloomDay - minBloomDay
// n = bloomDay.length
// Time: O(n + (n log d))
// Space: O(1)
// not 100% sure on this complexity analysis
class Solution {
    int[] bloomDay;
    int m, k;
    
    public int minDays(int[] bloomDay, int m, int k) {
        this.bloomDay = bloomDay;
        this.m = m;
        this.k = k;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        
        int minDays = binarySearch(min, max);
        if (minDays > max) return -1;
        return minDays;
    }
    
    private int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;     
            int bouquetCount = countBouquets(mid);
            
            if (bouquetCount < m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return left;
    }
    
    private int countBouquets(int currDay) {
        int bouquetCount = 0;
        int flowerCount = 0;
        for (int day : bloomDay) {
            if (day <= currDay)
                flowerCount++;
            else
                flowerCount = 0;
            
            if (flowerCount == k) {
                bouquetCount++;
                flowerCount = 0;
            }
        }
        
        return bouquetCount;
    }
}
