// n = arr.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        while (k > 0) {
            Map.Entry<Integer, Integer> polled = pq.poll();
            if (k - polled.getValue() < 0) {
                return pq.size() + 1;
            } else {
                k -= polled.getValue();
            }
        }
        return pq.size();
    }
}