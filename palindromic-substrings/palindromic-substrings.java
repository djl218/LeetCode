// Time: O(n^2)
// Space: O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        
        boolean[][] dp = new boolean[n][n];
        
        // single letter palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            result++;
        }
        
        // double letter palindromes
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) result++;
        }
        
        // palindromes greater than or equal to 3 letters
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) result++;
            }
        }
        
        return result;
    }
}