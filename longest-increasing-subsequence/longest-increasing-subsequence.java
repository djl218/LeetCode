// Brute-force recursion
class Solution {
    public int lengthOfLIS(int[] nums) {
        return findLISLengthRecursive(nums, 0, -1);
    }
    
    private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }
        
        int c1 = 0;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            c1 = 1 + findLISLengthRecursive(nums, currentIndex+1, currentIndex);
        }
        
        int c2 = findLISLengthRecursive(nums, currentIndex+1, previousIndex);
        
        return Math.max(c1, c2);
    }
}
// Top down with memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length+1];
        return findLISLengthRecursive(dp, nums, 0, -1);
    }
    
    private int findLISLengthRecursive(Integer[][] dp, int[] nums, int currentIndex, int previousIndex) {
        if (currentIndex == nums.length) {
            return 0;
        }
        
        if (dp[currentIndex][previousIndex+1] == null) {
            int c1 = 0;
            if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
                c1 = 1 + findLISLengthRecursive(dp, nums, currentIndex+1, currentIndex);
            }
        
            int c2 = findLISLengthRecursive(dp, nums, currentIndex+1, previousIndex);
            dp[currentIndex][previousIndex+1] = Math.max(c1, c2);
        }
        
        return dp[currentIndex][previousIndex+1];
    }
}
// Bottom-up dynamic programming with tabulation
// Recursive Formula
// if num[i] > num[j] => dp[i] = dp[j] + 1 if there is no bigger LIS for 'i'
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) dp[i] = 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
