// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1 && !Character.isDigit(s.charAt(0)))
            return 0;
        
        char sign = '\0';
        boolean firstNonWhitespace = false;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isLetter(c) && !firstNonWhitespace) return 0;
            
            if (c == '.' && firstNonWhitespace) break;
            if (c == '.' && !firstNonWhitespace) return 0;
            
            if (Character.isWhitespace(c) && firstNonWhitespace)
                break;
            
            if ((c < '0' || c > '9') && firstNonWhitespace)
                break;
            
            if ((c == '-' || c == '+') && sign == '\0') {
                sign = c;
            }
            
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
            
            if (!Character.isWhitespace(c)) firstNonWhitespace = true;
            if (i == s.length() - 1 && !firstNonWhitespace) return 0;
        }
        
        // Get rid of leading zeroes
        String parsedNum = sb.toString();
        StringBuilder sbNoZer = new StringBuilder();
        boolean leadingZero = true;
        for (char c : parsedNum.toCharArray()) {
            if (c == '0' && leadingZero)
                continue;
            
            if (c != 0) leadingZero = false;
            
            if (!leadingZero) {
                sbNoZer.append(c);
            }
        }
        
        // Make sure that 'sbNoZer' isn't bigger than Long max
        if (sbNoZer.length() > 11) {
            if (sign == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        
        // Make sure that long value doesn't exceed Integer max
        long parsed = 0;
        try {
            parsed = Long.valueOf(sbNoZer.toString());
        } catch (NumberFormatException e) {
            System.err.println("Unable to format " + e);
        }
        
        if (sign == '-') parsed *= -1;
        
        if (parsed > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (parsed < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int) parsed;
    }
}