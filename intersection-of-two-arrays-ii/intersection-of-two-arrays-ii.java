// m = nums1.length, n = nums2.length
// Time: O(m + n)
// Space: O(min(m, n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        
        return result;
    }
}