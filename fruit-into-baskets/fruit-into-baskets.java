// n = tree.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            if (map.size() <= 2) max = Math.max(max, i - j + 1);
            while (map.size() > 2) {
                map.put(tree[j], map.get(tree[j]) - 1);
                if (map.get(tree[j]) == 0) map.remove(tree[j]);
                j++;
            }
        }
        return max;
    }
}