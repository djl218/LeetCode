// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int count = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return (max + 1) / 2;
    }
}