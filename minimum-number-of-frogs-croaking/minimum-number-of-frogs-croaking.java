// n = croakOfFrogs.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] counts = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        int result = 0;
        int count = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            counts[map.get(c)]++;
            if (map.get(c) > 0) {
                counts[map.get(c) - 1]--;
            }
            if (c == 'c') {
                result = Math.max(result, ++count);
            } else if (counts[map.get(c) - 1] < 0) {
                return -1;
            } else if (c == 'k') {
                count--;
            }
        }
        return count == 0 ? result : -1;
    }
}