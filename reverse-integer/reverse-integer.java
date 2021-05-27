// n = number of digits in x
// Time: O(n)
// Space: O(n) 
// although -2^31 <= x <= 2^31 - 1 so you could also consider O(1)
class Solution {
    public int reverse(int x) {
        int start = 0;
        char[] numChar = String.valueOf(x).toCharArray();
        
        if (numChar[0] == '-') start = 1;
        
        for (int l = start, r = numChar.length - 1; l < r; l++, r--) {
            char temp = numChar[l];
            numChar[l] = numChar[r];
            numChar[r] = temp;
        }
        
        long newNum = Long.valueOf(new String(numChar));
        if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE)
            return 0;
        
        return (int) newNum;
    }
}