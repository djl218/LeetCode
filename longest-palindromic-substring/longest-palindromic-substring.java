class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = true;
        
        int maxLength = 0;
        String result = s.substring(0, 1);
        for (int startIndex = s.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < s.length(); endIndex++) {
                if (s.charAt(startIndex) == s.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        if (endIndex - startIndex + 1 > maxLength) {
                            maxLength = endIndex - startIndex + 1;
                            result = s.substring(startIndex, endIndex + 1);
                        }
                    }
                }
            }
        }
        return result;
    }
}