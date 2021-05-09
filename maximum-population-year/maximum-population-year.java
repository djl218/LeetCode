class Solution {
    public int maximumPopulation(int[][] logs) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] log : logs) {
            min = Math.min(min, log[0]);
            max = Math.max(max, log[1]);
        }
        
        int span = max - min;
        int[] years = new int[span];
        
        for (int[] log : logs) {
            int start = log[0] - min;
            int end = log[1] - min;
            for (int i = start; i < end; i++) {
                years[i]++;
            }
        }
        
        int maxPop = 0;
        for (int p : years)
            maxPop = Math.max(maxPop, p);
        
        int earliest = 0;
        for (int i = 0; i < years.length; i++) {
            if (years[i] == maxPop) {
                earliest = i;
                break;
            }
        }
        
        return min + earliest;
    }
}