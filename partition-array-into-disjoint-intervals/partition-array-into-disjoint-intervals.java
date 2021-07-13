// n = nums.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxes = new int[n];
        int[] mins = new int[n];
        
        int max = nums[0];
        int min = nums[n - 1];
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxes[i] = max;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            mins[i] = min;
        }
        
        for (int i = 0; i < n; i++) {
            if (maxes[i] <= mins[i + 1]) {
                return i + 1;
            }
        }
        
        return -1;
    }
}