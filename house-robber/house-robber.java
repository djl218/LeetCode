/*
class Solution {
    public int rob(int[] nums) {
        return findMax(nums, 0);  
    }
    
    private int findMax(int[] nums, int curr) {
        if (curr >= nums.length) return 0;
        
        int skip = findMax(nums, curr + 1);
        int steal = nums[curr] + findMax(nums, curr + 2);
        
        return Math.max(skip, steal);
    }
}
*/
/*
class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        return findMax(dp, nums, 0);
    }
    
    private int findMax(int[] dp, int[] nums, int curr) {
        if (curr >= nums.length) return 0;
        
        if (dp[curr] == 0) {
            int skip = findMax(dp, nums, curr + 1);
            int steal = nums[curr] + findMax(dp, nums, curr + 2);
        
            dp[curr] = Math.max(skip, steal);
        }
            
        return dp[curr];
    }
}
*/
/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[n];
    }
}
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int n1 = 0, n2 = nums[0], temp;
        for (int i = 1; i < n; i++) {
            temp = Math.max(nums[i] + n1, n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}

