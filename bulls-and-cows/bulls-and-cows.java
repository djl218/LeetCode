// secret.length() == guess.length()
// n = secret.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        Map<Integer, Character> secretMap = new HashMap<>();
        Map<Character, Integer> secretCounts = new HashMap<>();
        boolean[] bullSpot = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            char c = secret.charAt(i);
            secretMap.put(i, c);
            secretCounts.put(c, secretCounts.getOrDefault(c, 0) + 1);
        }
        
        // Check for bulls
        int bullCount = 0, cowCount = 0;
        for (int i = 0; i < n; i++) {
            char guessDigit = guess.charAt(i);
            char secretDigit = secretMap.get(i);
             if (guessDigit == secretDigit) {
                bullCount++;
                bullSpot[i] = true; 
                secretCounts.put(guessDigit, secretCounts.get(guessDigit) - 1);
                if (secretCounts.get(guessDigit) == 0) secretCounts.remove(guessDigit);
             }
        }
        
        // Check for cows
        for (int i = 0; i < n; i++) {
            char guessDigit = guess.charAt(i);
            char secretDigit = secretMap.get(i);
            if (!bullSpot[i] && secretCounts.containsKey(guessDigit)) {
                cowCount++;
                secretCounts.put(guessDigit, secretCounts.get(guessDigit) - 1);
                if (secretCounts.get(guessDigit) == 0) secretCounts.remove(guessDigit);
            }
        }
        
        StringBuilder hint = new StringBuilder();
        hint.append(bullCount);
        hint.append('A');
        hint.append(cowCount);
        hint.append('B');
        
        return hint.toString();
    }
}