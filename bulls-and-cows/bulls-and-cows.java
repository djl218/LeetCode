// secret.length() == guess.length()
// n = secret.length()
// Time: O(n)
// Space: O(n)
// Initial attempt - too many data structures, too many passes
// Take-away: No need to keep track of bulls in map. Only cows need to be mapped.
// This removes need for 'bullSpot' and 'secretMap'.
// Reduces space to O(1).
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

/*
secret digits will be stored as positive counts.
guess digits will be stored as negative counts.

if there is a negative value on the index spot for currect secret digit
then there was already a guess digit with that value.  this counts as a cow

if there is a positive value on the index spot for current guess digit
then there was already a secret digit with that value.  this counts as a cow
*/
// Time: O(n)
// Space: O(1)
class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] map = new int[10];
        
        int bullCount = 0, cowCount = 0;
        for (int i = 0; i < n; i++) {
            char secretDigit = secret.charAt(i);
            char guessDigit = guess.charAt(i);
            
            if (secretDigit == guessDigit) {
                bullCount++;
            } else {
                if (map[secretDigit - '0'] < 0)
                    cowCount++;
                if (map[guessDigit - '0'] > 0)
                    cowCount++;
                
                map[secretDigit - '0']++;
                map[guessDigit - '0']--;
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
