// Time: O(len1 + len2)
// Space: O(1)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        int[] mapS1 = new int[26];
        int[] mapS2 = new int[26];
        
        for (char c : s1.toCharArray())
            mapS1[c - 'a']++;
        
        for (int i = 0; i < len2; i++) {    
            if (i >= len1)
                mapS2[s2.charAt(i - len1) - 'a']--;
            
            mapS2[s2.charAt(i) - 'a']++;
            
            if (Arrays.equals(mapS1, mapS2))
                return true;
        }
        
        return false;
    }
}