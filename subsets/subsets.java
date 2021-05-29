// n = nums.length
// Time: O(n * 2^n)
// Space: O(n)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int idx, List<Integer> list) {
        result.add(new ArrayList<>(list));
        
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }
}