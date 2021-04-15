// n = nums.length
// Time: O(n^k) . . . i think
// Space: O(n + k) to account for recursion stack and possibleSubsetSums . . . i think
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) return false;
        int targetSubsetSum = totalSum / k;
        Arrays.sort(nums);
        return isEvenlyPartitionable(nums, targetSubsetSum, new int[k], nums.length - 1);
    }
    
    private boolean isEvenlyPartitionable(int[] nums, int targetSubsetSum, int[] possibleSubsetSums, int currIdx) {
        if (currIdx == -1) {
            for (int sum : possibleSubsetSums)
                if (sum != targetSubsetSum) return false;
            
            return true;
        }
        
        int currNum = nums[currIdx];
        
        for (int i = 0; i < possibleSubsetSums.length; i++) {
            if (possibleSubsetSums[i] + currNum > targetSubsetSum)
                continue;
            
            possibleSubsetSums[i] += currNum;
            if (isEvenlyPartitionable(nums, targetSubsetSum, possibleSubsetSums, currIdx - 1))
                return true;
            
            possibleSubsetSums[i] -= currNum;
        }
        
        return false;
    }
}