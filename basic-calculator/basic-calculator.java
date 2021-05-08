class Solution {
    int idx = 0;
    
    public int calculate(String s) {
        int result = 0;
        boolean isNeg = false;
        while (idx < s.length() && s.charAt(idx) != ')') {
            char c = s.charAt(idx);
            if (Character.isWhitespace(c)) {
                idx++;
            } else if (c == '-') {
                isNeg = true;
                idx++;
            } else if (c == '+') {
                isNeg = false;
                idx++;
            } else if (Character.isDigit(c)) {
                int currDigit = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    currDigit = currDigit * 10 + s.charAt(idx++) - '0';
                }
                if (isNeg) {
                    result -= currDigit;
                } else {
                    result += currDigit;
                }
            } else if (c == '(') {
                idx++;
                if (isNeg) {
                    result -= calculate(s);
                } else {
                    result += calculate(s);
                }
                idx++;
            }
        }
        return result;
    }
}