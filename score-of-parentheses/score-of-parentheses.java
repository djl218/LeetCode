// n = s.length()
// Time: O(n)
// Space: O(n)
class Solution {
    int i = 0;
    public int scoreOfParentheses(String s) {
        int score = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == '(') {
                if (s.charAt(i) == ')') {
                    score++;
                    i++;
                } else {
                    score += 2 * scoreOfParentheses(s);
                }
            } else {
                return score;
            }
        }
        return score;
    }
}