// n = s.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int numSplits(String s) {
        int n = s.length();
        Map<Character, Integer> mapL = new HashMap<>();
        Map<Character, Integer> mapR = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            mapR.put(s.charAt(i), mapR.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int waysToSplit = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            mapL.put(c, mapL.getOrDefault(c, 0) + 1);
            mapR.put(c, mapR.get(c) - 1);
            if (mapR.get(c) == 0) {
                mapR.remove(c);
            }
            if (mapL.size() == mapR.size()) {
                waysToSplit++;
            }
        }
        
        return waysToSplit;
    }
}