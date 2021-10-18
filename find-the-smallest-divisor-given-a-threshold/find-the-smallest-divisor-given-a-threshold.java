// n = nums.length
// Time: O(n log (max))
// Space: O(1)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = 1_000_000;
        int mid = 0;
        while (min < max) {
            mid = min + (max - min) / 2;
            int currSum = divSum(nums, mid);
            if (currSum > threshold) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private int divSum(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / mid);
        }
        return sum;
    }
}