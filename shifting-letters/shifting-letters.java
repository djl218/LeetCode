// n = s.length() = shifts.length
// Time: O(n)
// Space: O(n)
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        long shiftSum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            shiftSum = (shiftSum + shifts[i]) % 26;
            arr[i] = (char)((arr[i] - 'a' + shiftSum) % 26 + 'a');
        }
        return new String(arr);
    }
}