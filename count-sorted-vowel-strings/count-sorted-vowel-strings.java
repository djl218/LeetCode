// Time: O(n^2)
// Space: O(1)
class Solution {
    public int countVowelStrings(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                curr += j + 1;
                result += curr;
            }
        }
        return result;
    }
}