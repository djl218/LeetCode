// m = strings.length, n = max(strings[i].length)
// Time: O(m * n)
// Space: O(m)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<List<Integer>, List<String>> map = new HashMap<>();
        
        for (String string : strings) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < string.length(); i++) {
                int diff = string.charAt(i) - string.charAt(i - 1);
                if (diff < 0) diff = 26 + diff;
                list.add(diff);
            }
            map.putIfAbsent(list, new ArrayList<>());
            map.get(list).add(string);
        }
        
        for (List<Integer> list : map.keySet())
            result.add(map.get(list));
        
        return result;
    }
}
