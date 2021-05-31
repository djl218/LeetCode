// n = servers.length, m = tasks.length
// Time: O((m + n)log n)
// Space: O(n)
class Available implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0])
            return a[1] - b[1];
        
        return a[0] - b[0];
    }
}

class Unavailable implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[2] == b[2]) {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        }
        return a[2] - b[2];
    }
}
/*
    curr[0] = weight
    curr[1] = idx
    curr[2] = time
*/
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        
        PriorityQueue<int[]> available = new PriorityQueue<>(new Available());
        PriorityQueue<int[]> unavailable = new PriorityQueue<>(new Unavailable());
        for (int i = 0; i < n; i++)
            available.offer(new int[]{servers[i], i, 0});
        
        int time = 0;
        int taskIdx = 0;
        while (taskIdx < m) {
            while (!unavailable.isEmpty() && unavailable.peek()[2] <= time) {
                available.offer(unavailable.poll());
            }
            if (available.isEmpty()) {
                time = unavailable.peek()[2];
                continue;
            }
            while (taskIdx < m && taskIdx <= time) {
                if (!available.isEmpty()) {
                    int[] curr = available.poll();
                    ans[taskIdx] = curr[1];
                    curr[2] = time + tasks[taskIdx];
                    unavailable.offer(curr);
                    taskIdx++;
                } else {
                    break;
                }
            }
            time++;
        }
  
        return ans;
    }
}
