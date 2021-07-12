// n = wordsDict.length
// m = word1.length() + word2.length()
// Time: O(n * m)
// Space: O(1)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
            }
            if (wordsDict[i].equals(word2)) {
                idx2 = i;
            }
            
            if (idx1 != -1 && idx2 != -1) {
                minDist = Math.min(minDist, Math.abs(idx1 - idx2));
            }
        }
        return minDist;
    }
}