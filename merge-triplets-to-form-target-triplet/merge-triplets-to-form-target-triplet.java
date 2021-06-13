// n = triplets.length
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] hopefulTriplet = new int[3];
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0]
               || triplets[i][1] > target[1]
               || triplets[i][2] > target[2])
            {
                continue;
            } else {
                hopefulTriplet[0] = Math.max(hopefulTriplet[0], triplets[i][0]);
                hopefulTriplet[1] = Math.max(hopefulTriplet[1], triplets[i][1]);
                hopefulTriplet[2] = Math.max(hopefulTriplet[2], triplets[i][2]);
            }
        }
        
        return hopefulTriplet[0] == target[0] && hopefulTriplet[1] == target[1]
            && hopefulTriplet[2] == target[2];
    }
}