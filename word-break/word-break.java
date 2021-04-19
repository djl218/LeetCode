// My attempt with a clear lack of dynamism - doesn't work
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            String wordCheck = sb.toString();
            if (set.contains(wordCheck))
                sb = new StringBuilder();
        }
        if (sb.length() > 0) return false;
        
        return true;
    }
}

// Recursion
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordCheck(s, new HashSet(wordDict), 0);
    }
    
    private boolean wordCheck(String s, HashSet<String> wordDict, int start) {
        if (start == s.length()) return true;
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordCheck(s, wordDict, end))
                return true;
        }
        return false;
    }
}

// Top-down with memoization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordCheck(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean wordCheck(String s, HashSet<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        
        if (memo[start] != null)
            return memo[start];
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordCheck(s, wordDict, end, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
}

// Bottom-up dp with tabulation
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
