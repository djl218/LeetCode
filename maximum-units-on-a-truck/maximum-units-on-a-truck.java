// n = boxTypes.length;
// Time: O(n log n)
// Space: O(1)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int boxCount = 0;
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            if (boxCount + boxType[0] > truckSize) {
                int boxesLeft = truckSize - boxCount;
                unitCount += boxesLeft * boxType[1];
                break;
            } else {
                unitCount += boxType[0] * boxType[1];
                boxCount += boxType[0];
            }
        }
        return unitCount;
    }
}