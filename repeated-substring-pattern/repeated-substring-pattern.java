// n = s.length
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 1; i < n / 2 + 1; i++) {
            set.add(s.substring(0, i));
        }
        for (String sub : set) {
            int len = sub.length();
            for (int i = 0; i <= n - len; i += len) {
                String currSub = s.substring(i, i + len);
                if (!currSub.equals(sub)) {
                    break;
                }
                if (i == n - len) {
                    return true;
                }
            }
        }
        return false;
    }
}