// n = rungs.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int addRungs(int[] rungs, int dist) {
        int curr = 0;
        int xtraRungs = 0;
        for (int i = 0; i < rungs.length; i++) {
            if (rungs[i] - curr > dist) {
                int rungsToAdd = (rungs[i] - curr) / dist;
                if (curr + rungsToAdd * dist == rungs[i]) {
                    rungsToAdd--;
                }
                xtraRungs += rungsToAdd;
            }
            curr = rungs[i];
        }
        return xtraRungs;
    }
}