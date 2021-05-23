// n = s.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean checkZeroOnes(String s) {
        int maxZero = 0, maxOne = 0;
        int currZero = 0, currOne = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '0') {
                currOne = 0;
                currZero++;
                maxZero = Math.max(maxZero, currZero);
            }
            if (c == '1') {
                currZero = 0;
                currOne++;
                maxOne = Math.max(maxOne, currOne);
            }
        }
        
        return maxOne > maxZero;
    }
}