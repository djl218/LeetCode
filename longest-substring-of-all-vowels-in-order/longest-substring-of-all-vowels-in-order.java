class Solution {
    public int longestBeautifulSubstring(String word) {
        int max = 0, vowelCount = 1, subLength = 1;
        for (int i = 1; i < word.length(); i++) {
            subLength++;
            
            if (word.charAt(i) < word.charAt(i - 1)) {
                vowelCount = 0;
                subLength = 1;
            }
            
            if (word.charAt(i) != word.charAt(i - 1)) 
                vowelCount++;
            
            if (vowelCount == 5)
                max = Math.max(max, subLength); 
        }
        
        return max;
    }
}