// n = words.length
// Time: O(n)
// Space: O(1) - ignore space for output List
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while (idx < words.length) {
            int last = idx + 1;
            int count = words[idx].length();
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth)
                    break;
                
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[idx]);
            int diff = last - idx - 1;
            
            if (last == words.length || diff == 0) {
                for (int i = idx + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int space = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = idx + 1; i < last; i++) {
                    for (int s = space; s >= 0; s--) {
                        sb.append(" ");
                    }
                    if (r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            idx = last;
        }
        return result;
    }
}