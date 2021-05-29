// n = s.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            maxHeap.offer(entry);
        
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) { 
            Map.Entry<Character, Integer> poll1 = maxHeap.poll();
            sb.append(poll1.getKey());
            poll1.setValue(poll1.getValue() - 1);

            Map.Entry<Character, Integer> poll2 = maxHeap.poll();
            sb.append(poll2.getKey());
            poll2.setValue(poll2.getValue() - 1);
            
            if (poll1.getValue() > 0) maxHeap.offer(poll1);
            if (poll2.getValue() > 0) maxHeap.offer(poll2);
        }
        
        if (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> poll3 = maxHeap.poll();
            sb.append(poll3.getKey());
            poll3.setValue(poll3.getValue() - 1);
            if (poll3.getValue() > 0) return "";
        }
        
        return sb.toString();
    }
}