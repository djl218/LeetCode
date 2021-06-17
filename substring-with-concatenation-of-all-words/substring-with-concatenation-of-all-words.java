// sLen = s.length(), wLen = words.length
// Time: O(sLen * wLen)
// Space: O(wLen)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
 
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            if (map.containsKey(s.substring(i, i + wordLength))) {
                Map<String, Integer> tempMap = new HashMap<>(map);
                int j = i;
                while (j < s.length() - wordLength + 1
                       && tempMap.containsKey(s.substring(j, j + wordLength))
                       && tempMap.size() > 0)
                {
                    String sub = s.substring(j, j + wordLength);
                    tempMap.put(sub, tempMap.get(sub) - 1);
                    if (tempMap.get(sub) == 0) {
                        tempMap.remove(sub);
                    }
                    j += wordLength;
                }
                if (tempMap.size() == 0) {
                    result.add(i);
                }
            }
        }
        
        return result;
    }
}