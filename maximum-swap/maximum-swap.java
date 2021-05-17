// 0 <= num <= 10^8, stNum.length <= 9
// Time: O(9) = O(1)
// Space: O(9) = O(1)
class Solution {
    public int maximumSwap(int num) {
        int result = num;
        char[] stNum = String.valueOf(num).toCharArray();
        for (int i = 0; i < stNum.length; i++) {
            int maxDig = 0, maxIdx = Integer.MAX_VALUE;
            for (int j = i + 1; j < stNum.length; j++) {
                if (stNum[j] - '0' >= maxDig) {
                    maxDig = stNum[j] - '0';
                    maxIdx = j;
                    if (maxIdx != Integer.MAX_VALUE) {
                        swap(stNum, i, maxIdx);
                        int newNum = Integer.valueOf(new String(stNum));
                        result = Math.max(result, newNum);
                        swap(stNum, i, maxIdx);
                    }
                }
            }
        }
        return result;
    }
    
    private void swap(char[] stNum, int a, int b) {
        char temp = stNum[a];
        stNum[a] = stNum[b];
        stNum[b] = temp;
    }
}