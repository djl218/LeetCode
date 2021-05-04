// n = nums.length
// Time: O(n^2)
// Space: O(n) - this is for sort; ignoring space for output
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0)
                while (i < n - 2 && nums[i] == nums[i - 1]) i++;
            
            getThreeSum(nums, i, i + 1, n - 1);
        }
        
        return result;
    }
    
    private void getThreeSum(int[] nums, int i, int j, int k) {
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(List.of(nums[i], nums[j], nums[k]));
                while (j < k && nums[j] == nums[j + 1]) j++;
                j++;
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else if (nums[i] + nums[j] + nums[k] > 0) {
                k--;
            }
        }
    }
}