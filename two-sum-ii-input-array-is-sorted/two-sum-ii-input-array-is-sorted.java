/*
// n = numbers.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            
            map.put(numbers[i], i);
        }
        
        return new int[0];
    }
}
*/
// Time: O(n)
// Space: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            
            if (numbers[left] + numbers[right] > target)
                right--;
            if (numbers[left] + numbers[right] < target)
                left++;
        }
        
        return new int[0];
    }
}