// len = number of digits in n
// Time: O(n)
// Space: O(n)
// len is at most 10 digits so could be considered constant
class Solution {
    public int nextGreaterElement(int n) {
        String strN = String.valueOf(n);
        char[] arrN = strN.toCharArray();
        int len = arrN.length;
        for (int i = len - 1; i >= 1; i--) {
            if (arrN[i - 1] < arrN[i]) {
                for (int j = len - 1; j > i - 1; j--) {
                    if (arrN[j] > arrN[i - 1]) {
                        swap(arrN, i - 1, j);
                        reverse(arrN, i, len - 1);
                        try {
                            return Integer.valueOf(new String(arrN));
                        } catch (Exception e) {
                            return -1;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private void swap(char[] arrN, int a, int b) {
        char temp = arrN[a];
        arrN[a] = arrN[b];
        arrN[b] = temp;
    }
    
    private void reverse(char[] arrN, int left, int right) {
        for (int l = left, r = right; l < r; l++, r--) {
            swap(arrN, l, r);
        }
    }
}