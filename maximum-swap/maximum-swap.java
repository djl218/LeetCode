/* 
    0 <= num <= 10^8, stNum.length <= 9
    Because stNum.length is at most 9 digits, the time and space
    can be considered constant. However if it was possile for the input
    to be much longer, then this algorithm would not be ideal, as it would
    be O(n^2) time with n being stNum.length.
    
    Many of the top solutions on the discussion board had "O(n^2)" time as
    well, so I think that it is acceptable for this use case because it is 
    guaranteed that there won't be more than 9 digits in the input.
*/
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