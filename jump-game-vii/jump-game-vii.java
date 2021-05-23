// n = s.length()
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int farthest = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int start = Math.max(curr + minJump, farthest + 1);
            for (int j = start; j < curr + maxJump + 1; j++) {
                if (j >= n) break;
                if (s.charAt(j) == '0') {
                    if (j == n - 1) return true;
                    queue.offer(j);
                }
            }
            farthest = curr + maxJump;
        }
        
        return false;
    }
}