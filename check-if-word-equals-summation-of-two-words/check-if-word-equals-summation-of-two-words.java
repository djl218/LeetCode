// i = firstWord.length(), j = secondWord.length(), k = targetWord.length()
// Time: O(i + j + k)
// Space: O(1)
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int target = stringToInt(targetWord);
        int first = stringToInt(firstWord);
        int second = stringToInt(secondWord);
        
        return target == first + second;
    }
    
    private int stringToInt(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c - 'a');
        }
        return Integer.valueOf(sb.toString());
    }
}