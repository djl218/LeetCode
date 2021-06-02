// n = number.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb1 = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb1.append(c);
            }
        }
        
        String parsed = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        int count = 0;
        for (int i = 0; i < parsed.length(); i++) {
            if (count == 0 && parsed.length() - i <= 4) {
                if (parsed.length() - i <= 3) {
                    sb2.append(parsed.charAt(i));
                }
                if (parsed.length() - i == 4) {
                    sb2.append(parsed.charAt(i));
                    sb2.append(parsed.charAt(i + 1));
                    sb2.append('-');
                    i++;
                }
            } else {
                sb2.append(parsed.charAt(i));
                count++;
                if (count == 3) {
                    sb2.append('-');
                    count = 0;
                }
            }
        }
        
        return sb2.toString();
    }
}