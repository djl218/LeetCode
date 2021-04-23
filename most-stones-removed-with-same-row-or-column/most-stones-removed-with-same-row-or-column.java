/*
  DFS explanation
    * Use dfs to get count of all connected components.
    * Every single connected component can be reduced to a single node.
    * This reduction to a single node effectively removes all "stones"
      except for the one single "stone" that remains.
    * So when we subtract the connectedComponentCount from the 
      numberOfNodes, the difference is the number of "stones"
      that can be removed.
      
    * This logic that is used in dfs is the same logic used in 
      Union Find data structure except Union Find does it faster
*/

// n = stones.length
// Time: O(n^2)
// Space: O(n)

// DFS
class Solution {
    public int removeStones(int[][] stones) {
        int numberOfNodes = stones.length;
        int connectedComponentCount = 0;
        Set<int[]> visited = new HashSet<>();
        
        for (int[] stone1 : stones) {
            if (visited.contains(stone1))
                continue;
            
            dfs(stones, stone1, visited);
            connectedComponentCount++;
        }
        
        return numberOfNodes - connectedComponentCount;
    }
    
    private void dfs(int[][] stones, int[] stone1, Set<int[]> visited) {
        visited.add(stone1);
        
        for (int[] stone2 : stones) {
            if (visited.contains(stone2))
                continue;
            
            if (stone1[0] == stone2[0] || stone1[1] == stone2[1])
                dfs(stones, stone2, visited);
        }
    }
}

// ----------------------------------------------------------------------

// Union Find
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] 
                    || stones[i][1] == stones[j][1]) 
                {
                    uf.union(i, j);
                }
            }
        }
        return n - uf.getCount();
    }
}

class UnionFind {
    int[] parent, rank;
    int count;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }
    
    private int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ])
                rank[rootP]++;
        }
        count--;
    }
    
    public int getCount() {
        return count;
    }
}
