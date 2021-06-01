// n = horizontalCuts.length, m = verticalCuts.length
// Time: O(nlogn + mlogm)
// Space: O(1)
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int lenH = horizontalCuts.length;
        int lenV = verticalCuts.length;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[lenH - 1]);
        for (int i = 1; i < lenH; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        long maxV = Math.max(verticalCuts[0], w - verticalCuts[lenV - 1]);
        for (int i = 1; i < lenV; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        long mod = 1_000_000_007;
        return (int) ((maxH * maxV) % mod); 
    }
}