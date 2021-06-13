// n = words.length, c = max characters in words[i]
// Time: O(n * c)
// Space: O(n * c)
class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (int value : map.values()) {
            if (value % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}