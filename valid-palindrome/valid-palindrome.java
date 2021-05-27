// n = s.length()
// Time: O(n)
// Space: O(1)
public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(Character.toLowerCase(c));
            
            if (Character.isDigit(c))
                sb.append(c);
        }
        
        String parsed = sb.toString();
        for (int l = 0, r = parsed.length() - 1; l < r; l++, r--) {
            if (parsed.charAt(l) != parsed.charAt(r))
                return false;
        }
        
        return true;
    }
}