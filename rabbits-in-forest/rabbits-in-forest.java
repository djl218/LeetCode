class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : answers) {
            if (num != 0) {
                map.put(num, map.getOrDefault(num, -1) + 1);
                if (map.get(num) > num) map.put(num, 0);
            }
            count++;
        }
        
        for (int key : map.keySet())
            count += key - map.get(key);
        
        return count;
    }
}