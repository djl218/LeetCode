// n = nums.length
// Time: O(n^2)
// Space: O(n) - this is for sort; ignoring space for output
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0) {
                while (i < n - 2 && nums[i] == nums[i - 1]) i++;
            }
            getThreeSum(nums, i, i + 1, n - 1);
        }
        return result;
    }
    
    private void getThreeSum(int[] nums, int l, int m, int r) {
        while (m < r) {
            if (nums[l] + nums[m] + nums[r] == 0) {
                result.add(List.of(nums[l], nums[m], nums[r]));
                while (m < r && nums[m] == nums[m + 1]) m++;
                m++;
            } else if (nums[l] + nums[m] + nums[r] < 0) {
                m++;
            } else {
                r--;
            }
        }
    }
}