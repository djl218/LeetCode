// With path compression and union by rank the time complexity is extremely close to O(1),
// but in theory it is O(n * alpha(n)) with alpha being Inverse Ackermann Function
// Also consider time to iterate through 'allowedSwaps'

// Space: O(n)
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int minHamming = 0;
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for (int[] pair : allowedSwaps) {
            uf.union(pair[0], pair[1]);
        }
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            int num = source[i];
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> store = map.get(root);
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            int num = target[i];
            Map<Integer, Integer> store = map.get(root);
            if (store.getOrDefault(num, 0) == 0) {
                minHamming++;
            } else {
                store.put(num, store.get(num) - 1);
            }
        }
        
        return minHamming;
    }
}

class UnionFind {
    int[] parent, rank;
    
    // instead of using makeset, we initialize all sets
    // at the same time in the constructor
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // utilizes path compression
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    // utilizes union by rank
    // for non-root node it doesn't matter what rank is
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
    }
}