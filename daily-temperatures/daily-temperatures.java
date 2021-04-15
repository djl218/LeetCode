// n = T.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int day = stack.pop();
                result[day] = i - day;
            }
            stack.push(i);
        }
        return result;
    }
}