// n = time.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int t : time) {
            for (int i = 60; i <= 960; i += 60) {
                if (map.containsKey(i - t)) {
                    count += map.get(i - t);
                }
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return count;
    }
}