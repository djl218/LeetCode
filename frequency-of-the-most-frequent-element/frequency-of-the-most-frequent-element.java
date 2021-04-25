// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int max = 1;
        long sum = 0;
        Arrays.sort(nums);
        
        for (int right = 0, left = 0; right < n; right++) {           
            sum += nums[right];
            
            long operationsToMakeWindowEqual = (long) nums[right] * (right - left + 1) - sum;
            while (k < operationsToMakeWindowEqual) {
                sum -= nums[left++];
                operationsToMakeWindowEqual = (long) nums[right] * (right - left + 1) - sum;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
