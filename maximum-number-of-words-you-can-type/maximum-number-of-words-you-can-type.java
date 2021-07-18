// n = text.split(" ").length, m = max(text[i].length())
// Time: O(m * n)
// Space: (1) - set will contain max of 26 characters
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        
        int count = 0;
        String[] arr = text.split(" ");
        for (String word : arr) {
            boolean isBroken = false;
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
                    isBroken = true;
                }
            }
            if (!isBroken) {
                count++;
            }
        }
        
        return count;
    }
}