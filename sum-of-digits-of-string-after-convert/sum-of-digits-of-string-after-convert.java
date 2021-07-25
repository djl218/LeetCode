// n = s.length()
// Time: O(n * k)
// Space: O(1)
// Not sure if complexity analysis is correct
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        while (k-- > 0) {
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                sum += sb.charAt(i) - '0';
            }
            sb = new StringBuilder();
            sb.append(sum);
        }
        return Integer.valueOf(sb.toString());
    }
}