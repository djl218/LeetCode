// n = n.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public String maxValue(String n, int x) {
        int len = n.length();
        boolean isNeg = false;
        boolean placed = false;
        if (n.charAt(0) == '-') isNeg = true;
        
        StringBuilder sb = new StringBuilder();
        if (!isNeg) {
            for (int i = 0; i < len; i++) {
                if (n.charAt(i) - '0' < x && !placed) {
                    sb.append(x);
                    sb.append(n.charAt(i));
                    placed = true;
                } else {
                    sb.append(n.charAt(i));
                }
            }
            if (!placed) sb.append(x);
        } else {
            for (int i = 1; i < len; i++) {
                if (n.charAt(i) - '0' > x && !placed) {
                    sb.append(x);
                    sb.append(n.charAt(i));
                    placed = true;
                } else {
                    sb.append(n.charAt(i));
                }
            }
            if (!placed) sb.append(x);
        }
        
        if (isNeg) sb.insert(0, '-');
        return sb.toString();
    }
}