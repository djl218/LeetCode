// Brute Force
// Time: O(n)
// Space: O(1)
class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        return k == 1 ? n : -1;
    }
}

// Heap
// Time: O(sqrt(n) * log k)
// Space: O(min(k, sqrt(n)))
class Solution {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 1; i < sqrtN + 1; i++) {
            if (n % i == 0) {
                maxHeap.offer(i);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
                if (i != n / i) {
                    maxHeap.offer(n / i);
                    if (maxHeap.size() > k) {
                        maxHeap.poll();
                    }
                }
            }
        }
        return maxHeap.size() == k ? maxHeap.poll() : -1;
    }
}
