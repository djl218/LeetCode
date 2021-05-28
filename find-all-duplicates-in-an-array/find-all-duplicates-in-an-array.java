// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                result.add(nums[i]);
        }
        
        return result;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}    
