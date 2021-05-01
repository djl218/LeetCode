// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public int firstUniqChar(String s) {
        int[] lib = new int[26];
        
        for (char c : s.toCharArray())
            lib[c - 'a']++;
        
        for (int i = 0; i < s.length(); i++) {
            if (lib[s.charAt(i) - 'a'] == 1)
                return i;
        }
        
        return -1;
    }
}