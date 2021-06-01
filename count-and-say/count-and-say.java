//  m = curr.length();
// Time: O(n * m)
// Space: O(m)
class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        while (n-- > 1) {
            StringBuilder sb = new StringBuilder();
            char c = curr.charAt(0);
            int count = 1;
            for (int i = 1; i < curr.length(); i++) {
                if (curr.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = curr.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            curr = sb.toString();
        }
        return curr;
    }
}