// n = horizontalCuts.length, m = verticalCuts.length
// Time: O((n log n) + (m log m))
// Space: O(n + m)
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Set<Integer> setH = new HashSet<>();
        Set<Integer> setV = new HashSet<>();
        
        for (int hCut : horizontalCuts) {
            setH.add(hCut);
        }
        for (int vCut : verticalCuts) {
            setV.add(vCut);
        }
        
        List<Integer> listH = new ArrayList<>(setH);
        List<Integer> listV = new ArrayList<>(setV);
        
        listH.add(0, 0);
        listV.add(0, 0);
        listH.add(h);
        listV.add(w);
        
        Collections.sort(listH);
        Collections.sort(listV);
        
        long maxDiffH = 0;
        for (int i = 1; i < listH.size(); i++) {
            int diff = listH.get(i) - listH.get(i - 1);
            maxDiffH = Math.max(maxDiffH, diff);
        }
        
        long maxDiffV = 0;
        for (int i = 1; i < listV.size(); i++) {
            int diff = listV.get(i) - listV.get(i - 1);
            maxDiffV = Math.max(maxDiffV, diff);
        }
        
        return (int) ((maxDiffH * maxDiffV) % (1000000007));
    }
}