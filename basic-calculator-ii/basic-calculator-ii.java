// Time: O(n)
// Space: O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int operator = '+';
        int num = 0;    
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                num = num * 10 + (currChar - '0');
            }
            if (!Character.isDigit(currChar) 
                && !Character.isWhitespace(currChar)
                || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(num);
                }
                if (operator == '-') {
                    stack.push(-num);
                }
                if (operator == '*') {
                    stack.push(stack.pop() * num);
                }
                if (operator == '/') {
                    stack.push(stack.pop() / num);
                }
                operator = currChar;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}