// Time: O(n*sqrt(n))
// Space: O(dp)
// dp = elements stored in dp matrix
class Solution {
    public int numSquares(int n) {
        int count = 1, square = 0;
        List<Integer> sqList = new ArrayList<>();
        while (square <= n) {
            sqList.add(square);
            count++;
            square = count * count;
        }
        int[][] dp = new int[sqList.size()][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= sqList.get(i)) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - sqList.get(i)]);
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

// Time: O(n*sqrt(n))
// Space: O(n)
class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        int maxSqIdx = (int) Math.sqrt(n) + 1;
        int[] sqList = new int[maxSqIdx];
        for (int i = 1; i < maxSqIdx; i++) {
            sqList[i] = i * i;
        }
        
        for (int i = 1; i < sqList.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j < sqList[i]) continue;
                
                dp[j] = Math.min(dp[j], 1 + dp[j - sqList[i]]);
            }
        }
        
        return dp[dp.length - 1];
    }
}
