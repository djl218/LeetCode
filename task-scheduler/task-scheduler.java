// The O(x log x) time for sort can be neglected because the sort
// is done on counts, which is constant length

// n = tasks.length
// Time: O(n)
// Space: (1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) counts[c - 'A']++;
        Arrays.sort(counts);
        
        int maxCount = counts[25];
        int idleTime = (maxCount - 1) * n;
        
        for (int i = counts.length - 2; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(maxCount - 1, counts[i]);
        }
        idleTime = Math.max(0, idleTime);
        
        return idleTime + tasks.length;
    }
}
