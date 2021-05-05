// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && i == left) {
                left++;
                continue;
            }
            if (nums[i] != 0 && i != left) {
                nums[left++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}