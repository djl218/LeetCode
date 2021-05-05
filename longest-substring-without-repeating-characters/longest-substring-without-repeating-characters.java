/*
// n = s.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int n = s.length();
        for (int left = 0, right = 0; right < n; right++) {
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);

            while (map.get(r) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
*/
// Time: O(n)
// Space: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int n = s.length();
        for (int left = 0, right = 0; right < n; right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                if (map.get(r) >= left)
                    left = map.get(r) + 1;
            }
            
            max = Math.max(max, right - left + 1);
            map.put(r, right);
        }
        
        return max;
    }
}