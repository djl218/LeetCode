// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        
        int runningSum = 0;
        int prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (prevSum == totalSum - runningSum) {
                return i;
            }
            prevSum += nums[i];
        }
        
        return -1;
    }
}