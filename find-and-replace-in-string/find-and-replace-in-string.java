// n = S.length()
// Time: O(n)
// Space: O(n)
// indexes.length will never exceed n, so it can just be considered O(n)
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            if (map.containsKey(i)) {
                String[] value = map.get(i);
                String source = value[0];
                String target = value[1];
                if (S.substring(i, i + source.length()).equals(source)) {
                    result.append(target);
                    i += source.length();
                } else {
                    result.append(S.charAt(i));
                    i++;
                }
            } else {
                result.append(S.charAt(i));
                i++;
            }
        }
        
        return result.toString();
    }
}
