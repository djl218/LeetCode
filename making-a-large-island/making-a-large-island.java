// n = grid.length
// Time: O(n^2)
// Space: O(n^2)
class Solution {
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] grid;
    int n;
    Map<Integer, Integer> map;
    int currIslandSize = 0;
    int combinedIslandSize = 0;
    int maxSize = 0;
    int islandID = 2;
    
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.map = new HashMap<>();
        
        boolean noZeroes = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    noZeroes = false;
                    Set<Integer> currIds = new HashSet<>();
                    for (int[] d : dir) {
                        int nextRow = i + d[0];
                        int nextCol = j + d[1];
                        if (inBounds(nextRow, nextCol)
                            && !currIds.contains(grid[nextRow][nextCol])
                            && map.containsKey(grid[nextRow][nextCol])) 
                        {
                            combinedIslandSize += map.get(grid[nextRow][nextCol]);
                            currIds.add(grid[nextRow][nextCol]);
                        } 
                        else if (inBounds(nextRow, nextCol) 
                            && grid[nextRow][nextCol] == 1)
                        {
                            dfs(nextRow, nextCol);
                            map.put(islandID, currIslandSize);
                            currIds.add(islandID);
                            islandID++;
                            
                            combinedIslandSize += currIslandSize;
                            currIslandSize = 0;
                        }
                    }
                    combinedIslandSize++;
                    maxSize = Math.max(maxSize, combinedIslandSize);
                    combinedIslandSize = 0;
                }
            }
        }
        
        return noZeroes ? n * n : maxSize;
    }
    
    private void dfs(int x, int y) {
        if (!inBounds(x, y) || grid[x][y] != 1)
        {
            return;
        }
        
        currIslandSize++;
        grid[x][y] = islandID;
        
        for (int[] d : dir) {
            int nextRow = x + d[0];
            int nextCol = y + d[1];
            dfs(nextRow, nextCol);
        }
    }
    
    private boolean inBounds(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}