// n = s.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                int currVal = stack.peek().getValue();
                stack.pop();
                stack.push(new Pair(c, currVal + 1));
                if (stack.peek().getValue() == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> popped = stack.pop();
            char key = popped.getKey();
            int value = popped.getValue();
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        
        return sb.reverse().toString();
    }
}