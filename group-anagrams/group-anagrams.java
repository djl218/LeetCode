/*
// Time: O(NKlogK)
// Space: O(NK)
// N is length of strs
// K is max length of a string in strs
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(word);
            } else {
                map.put(sorted, new ArrayList());
                map.get(sorted).add(word);
            }
        }
        List<List<String>> result = new ArrayList();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
*/
// Time and Space: O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] lib = new int[26];
        for (String word : strs) {
            Arrays.fill(lib, 0);
            for (int i = 0; i < word.length(); i++) {
                lib[word.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lib.length; i++) {
                sb.append('#');
                sb.append(lib[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(word);
        }
        return new ArrayList(map.values());
    }
}
