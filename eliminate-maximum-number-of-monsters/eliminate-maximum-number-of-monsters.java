// n = dist.length
// Time: O(n log n)
// Space: O(n)

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int monsterCount = 1;
        int minute = 1;
        
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double)dist[i] / (double)speed[i];
        }
        Arrays.sort(time);
        
        for (int i = 1; i < n; i++) {
            if (time[i] - minute <= 0) {
                break;
            }
            monsterCount++;
            minute++;
        }
        
        return monsterCount;
    }
}