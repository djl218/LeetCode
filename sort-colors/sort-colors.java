// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        
        int i = 0, left = 0, right = nums.length - 1;
        while (left < right && i < nums.length) {
            if (nums[i] == 0) {
                if (i != left) swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                if (i < right) swap(nums, i, right);
                right--;
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}