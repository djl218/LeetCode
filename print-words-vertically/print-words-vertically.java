// n = s.length(), m = max length of word in s
// Time: O(m * n)
// Space: O(m + n)
class Solution {
    public List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] split = s.split("\\s+");
        int n = split.length;
        
        int max = 0;
        for (String word : split)
            max = Math.max(max, word.length());
        
        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i >= split[j].length()) {
                    sb.append(" ");
                } else {
                    sb.append(split[j].charAt(i));
                }
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}