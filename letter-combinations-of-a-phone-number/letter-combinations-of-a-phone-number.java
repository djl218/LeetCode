// n = digits.length()
// Time: O((4^n) * n) 4 represents longest String in keys[]
// Space: O(n)

class Solution {
    final String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno",
                                       "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder combo, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(combo));
            return;
        }
        
        String currKey = keys[digits.charAt(index) - '0'];
        
        for (int i = 0; i < currKey.length(); i++) {
            combo.append(currKey.charAt(i));
            backtrack(digits, index + 1, new StringBuilder(combo), result);
            combo.deleteCharAt(combo.length() - 1);
        }
    }
}
