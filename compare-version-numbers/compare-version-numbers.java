// n = version1.length, m = version2.length
// Time: O(m + n)
// Space: O(m + n)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1arrStr = version1.split("\\.");
        String[] v2arrStr = version2.split("\\.");
        int n = Math.max(v1arrStr.length, v2arrStr.length);
        int[] v1arrInt = new int[n];
        int[] v2arrInt = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < v1arrStr.length) {
                v1arrInt[i] = Integer.valueOf(v1arrStr[i]);
            }
            if (i < v2arrStr.length) {
                v2arrInt[i] = Integer.valueOf(v2arrStr[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (v1arrInt[i] < v2arrInt[i]) {
                return -1;
            }
            if (v1arrInt[i] > v2arrInt[i]) {
                return 1;
            }
        }
        return 0;
    }
}
