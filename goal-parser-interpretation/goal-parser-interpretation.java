// n = command.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            char c = command.charAt(i);
            if (c == 'G') {
                result.append(c);
                i++;
            } else if (c == '(' && command.charAt(i + 1) == ')') {
                result.append('o');
                i += 2;
            } else {
                result.append("al");
                i += 4;
            }
        }
        return result.toString();
    }
}