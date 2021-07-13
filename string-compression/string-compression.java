// n = chars.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int j = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {            
            if (chars[i] != chars[i - 1]) {
                if (count == 1) {
                    chars[j++] = chars[i - 1];
                } else {
                    chars[j++] = chars[i - 1];
                    String strCount = String.valueOf(count);
                    for (int k = 0; k < strCount.length(); k++) {
                        chars[j++] = strCount.charAt(k);
                    }
                    count = 1;
                }
                
                if (i == chars.length - 1) {
                    chars[j++] = chars[i];
                }
            } else {
                count++;
                
                if (i == chars.length - 1) {
                    chars[j++] = chars[i];
                    String strCount = String.valueOf(count);
                    for (int k = 0; k < strCount.length(); k++) {
                        chars[j++] = strCount.charAt(k);
                    }
                }
            }
        }
        return j;
    }
}