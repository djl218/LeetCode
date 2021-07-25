// n = num.length();
// Time: O(n)
// Space: O(n)
class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();
        int prev = 0;
        boolean isSub = false;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i] - '0';
            if (n < change[n] || n == change[n] && isSub) {
                arr[i] = (char) (change[n] + '0');
                isSub = true;
            } else if (isSub) {
                break;
            }
        }
        return new String(arr);
    }
}