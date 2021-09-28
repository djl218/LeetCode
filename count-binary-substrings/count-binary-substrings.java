// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        return result + Math.min(prev, curr);
    }
}