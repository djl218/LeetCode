// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    int i = 0;
    
    public int calculate(String s) {
        int n = s.length();
        int sum = 0;
        boolean isNeg = false;
        while (i < n && s.charAt(i) != ')') {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (c == '+') {
                isNeg = false;
                i++;
            } else if (c == '-') {
                isNeg = true;
                i++;
            } else if (Character.isDigit(c)) {
                int currNum = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currNum = currNum * 10 + s.charAt(i) - '0';
                    i++;
                }
                if (isNeg) {
                    sum -= currNum;
                } else {
                    sum += currNum;
                }
            } else if (c == '(') {
                i++;
                if (isNeg) {
                    sum -= calculate(s);
                } else {
                    sum += calculate(s);
                }
                i++;
            }
        }
        return sum;
    }
}