// Time : O(n)
// Space: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        int[] taskTracker = new int[26];
        for (char task : tasks) {
            taskTracker[task - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int count : taskTracker) {
            if (count != 0) {
                pq.offer(count);
            }
        }
        
        Map<Integer, Integer> coolDown = new HashMap<>();
        int time = 0;
        while (!pq.isEmpty() || !coolDown.isEmpty()) {
            if (coolDown.containsKey(time - n - 1)) {
                pq.offer(coolDown.get(time - n - 1));
                coolDown.remove(time - n - 1);
            }
            if (!pq.isEmpty()) {
                int polled = pq.poll() - 1;
                if (polled != 0) {
                    coolDown.put(time, polled);
                }
            }
            time++;
        }
        return time;
    }
}