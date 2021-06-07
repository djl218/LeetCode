// n = nums.length
// Time: O(nlogn)
// Space: O(n)
class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) {
                count += n - i;
            }
        }
        return count;
    }
}