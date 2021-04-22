// sLen = s.length(), tLen = t.length()
// Time: O(sLen + tLen)
// Space: O(sLen + tLen)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>(); 
        for (char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);   
        
        int minLen = Integer.MAX_VALUE;
        int[] minIdxs = new int[]{-1, -1};
        
        int left = 0, right = 0;
        while (right < s.length()) {
            char cR = s.charAt(right);
            if (tMap.containsKey(cR))
                sMap.put(cR, sMap.getOrDefault(cR, 0) + 1);
            
            while (mapCheck(sMap, tMap)) {
                minLen = setMinLen(minLen, minIdxs, left, right);
                
                char cL = s.charAt(left);
                if (sMap.containsKey(cL)) {
                    sMap.put(cL, sMap.get(cL) - 1);
                    if (sMap.get(cL) == 0) {
                        sMap.remove(cL);
                    }
                }
                
                do left++;
                while (left < right &&
                       !tMap.containsKey(s.charAt(left)));
                 
                if (mapCheck(sMap, tMap))
                    minLen = setMinLen(minLen, minIdxs, left, right);
            }
    
            right++;
        }
        
        if (minIdxs[0] == -1 && minIdxs[1] == -1) return "";
        return s.substring(minIdxs[0], minIdxs[1] + 1);
    }
    
    private int setMinLen(int minLen, int[] minIdxs, int left, int right) {
        if (right - left + 1 < minLen) {
            minLen = right - left + 1;
            minIdxs[0] = left;
            minIdxs[1] = right;
        }
        return minLen;
    }
    
    private boolean mapCheck(Map<Character, Integer> sMap,
                             Map<Character, Integer> tMap)
    {
        for (char tKey : tMap.keySet()) {
            if (!sMap.containsKey(tKey)) return false;
            if (sMap.get(tKey) < tMap.get(tKey)) return false;
        }
        return true;
    }
}