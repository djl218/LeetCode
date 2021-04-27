// n = S.length()
// Time = O(n)
// Space = O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        
        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;
        
        int start = 0, lead = 0;
        for (int i = 0; i < S.length(); i++) {
            lead = Math.max(lead, map[S.charAt(i) - 'a']);
            if (lead == i) {
                result.add(lead - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}