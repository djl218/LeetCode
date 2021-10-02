// n = nums.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (String num : nums) {
            if (num.length() > target.length()) {
                continue;
            }
            String toConcat = target.substring(num.length(), target.length());
            if (map.containsKey(toConcat) && (num + toConcat).equals(target)) {
                count += map.get(toConcat);
                if (num.equals(toConcat)) {
                    count--;
                }
            }
        }
        return count;
    }
}