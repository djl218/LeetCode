// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                result[i] = nums[i - 1];
            } else {
                result[i] = nums[i - 1] * result[i - 1];
            }
        }
        int prev = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            result[i] = prev * result[i];
            prev *= nums[i];
        }
        result[0] = prev;
        return result;
    }
}