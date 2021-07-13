// n = words.length
// Time: O(n)
// Space: O(1)
// words[i].length <= 20 so can be considered constant
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            String prev = words[i - 1];
            if (curr.equals(prev)) {
                continue;
            }
            for (int j = 0; j < prev.length() && j < curr.length(); j++) {
                if (prev.charAt(j) == curr.charAt(j)) {
                    if (j == curr.length() - 1) {
                        return false;
                    }
                    continue;
                }
                for (int k = 0; k < order.length(); k++) {
                    if (order.charAt(k) == prev.charAt(j)) {
                        break;
                    }
                    if (order.charAt(k) == curr.charAt(j)) {
                        return false;
                    }
                }
                break;
            }
        }
        return true;
    }
}