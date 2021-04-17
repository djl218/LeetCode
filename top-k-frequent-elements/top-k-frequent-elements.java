// n = nums.length
// Time: O(n logk)
// Space: O(n + k)
/*
class FreqSort implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> entryA, 
                       Map.Entry<Integer, Integer> entryB)
    {
        return entryB.getValue() - entryA.getValue();
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>(new FreqSort());        
        
        /*
        **Alternatively use lambda function instead of Comparator**
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        */
        /*
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().getValue();
        }
        
        return result;
    }
}
*/

// n = nums.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int mostFreqCount = 0;
        for (int value : map.values())
            mostFreqCount = Math.max(mostFreqCount, value);
        
        List<Integer>[] buckets = new ArrayList[mostFreqCount + 1];
        for (int key : map.keySet()) {
            int index = map.get(key);
            if (buckets[index] == null)
                buckets[index] = new ArrayList<>();
            
            buckets[index].add(key);
        }
        
        int[] result = new int[k];
        int resultIdx = 0;
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[resultIdx++] = num;
                    k--;
                }
            }
        }
        
        return result;
    }
}
