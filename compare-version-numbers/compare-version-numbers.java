// n = Max(version1.length(), version2.length())
// Time: O(n)
// Space: O(n)
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        
        int longer = Math.max(v1Arr.length, v2Arr.length);
        
        List<Integer> v1List = new ArrayList<>();
        List<Integer> v2List = new ArrayList<>();
        
        int i1 = 0;
        for (; i1 < v1Arr.length; i1++) {
            v1List.add(Integer.valueOf(v1Arr[i1]));
        }
        while (i1++ < longer) v1List.add(0);
        
        int i2 = 0;
        for (; i2 < v2Arr.length; i2++) {
            v2List.add(Integer.valueOf(v2Arr[i2]));
        }
        while (i2++ < longer) v2List.add(0);
        
        for (int i12 = 0; i12 < v1List.size(); i12++) {
            if (v1List.get(i12) < v2List.get(i12)) return -1;
            if (v1List.get(i12) > v2List.get(i12)) return 1;
        }
        
        return 0;
    }
}