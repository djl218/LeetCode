// n = nums.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int degree = 0;
        for (int key : map.keySet())
            degree = Math.max(degree, map.get(key));
        
        map.clear();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);                
            while (degCount(map, degree) == 1) {
                minLen = Math.min(minLen, i - j + 1);
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0)
                    map.remove(nums[j]);
                j++;
            }
        }
        
        return minLen;
    }
    
    private int degCount(Map<Integer, Integer> map, int degree) {
        int count = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == degree)
                count++;
        }
        return count;
    }
}