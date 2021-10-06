// n = words.length, l = length of max word
// Time: O(l^2 * n)
// Space: O(n)
class Solution {
    Map<String, List<String>> map;
    Map<String, Integer> counts;
    
    public int longestStrChain(String[] words) {
        map = new HashMap<>();
        counts = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                continue;
            }
            map.putIfAbsent(word, new ArrayList<>());
            int n = word.length();
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < n; i++) {
                sb.deleteCharAt(i);
                String wordWithOneLessLetter = sb.toString();
                if (wordWithOneLessLetter.length() > 0) {
                    map.get(word).add(wordWithOneLessLetter);
                }
                sb.insert(i, word.charAt(i));
            }
        }
        int result = 0;
        for (String word : map.keySet()) {
            result = Math.max(result, dfs(word));
        }
        return result;
    }
    
    private int dfs(String currWord) {
        if (counts.containsKey(currWord)) {
            return counts.get(currWord);
        }
        int maxLength = 1;
        for (String child : map.get(currWord)) {
            if (map.containsKey(child)) {
                int currLength = 1 + dfs(child);
                maxLength = Math.max(maxLength, currLength);
            }
        }
        counts.put(currWord, maxLength);
        return maxLength;
    }
}