// m = num1.length, n = num2.length
// Time: O(max(m, n))
// Space: O(max(m, n))
class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        int carry  = 0;
        
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int p = m >= 0 ? num1.charAt(m) - '0' : 0;
            int q = n >= 0 ? num2.charAt(n) - '0' : 0;
            
            int value = (p + q + carry) % 10;
            carry = (p + q + carry) / 10;
            sb.insert(0, value);
            m--;
            n--;
        }
        
        if (carry != 0) sb.insert(0, carry);
        
        return sb.toString();
    }
}