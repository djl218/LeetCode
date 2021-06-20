// n = num.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder();
        boolean oddFound = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (oddFound) {
                sb.insert(0, num.charAt(i));
            } else if (!oddFound && (num.charAt(i) - '0') % 2 != 0) {
                sb.insert(0, num.charAt(i));
                oddFound = true;
            }
        }
        return sb.toString();
    }
}