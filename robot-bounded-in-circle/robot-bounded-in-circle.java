// n = instructions.length()
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int idx = 0;
        // north = 0, east = 1, south = 2, west = 3
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                idx = (idx + 3) % 4;
            } else if (instructions.charAt(i) == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += dirs[idx][0];
                y += dirs[idx][1];
            }
        }
        return (x == 0 && y == 0) || (idx != 0);
    }
}