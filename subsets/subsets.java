// Cascading
// n = nums.length
// Time: O(n * 2^n)
// Space: O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(num);
                result.add(newList);
            }
        }
        
        return result;
    }
}

// Backtracking
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
