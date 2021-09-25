// n = points.length
// Time: O(n log n)
// Space: O(n)
class Dist {
    int dist;
    int[] point;
    public Dist(int dist, int[] point) {
        this.dist = dist;
        this.point = point;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Dist[] distances = new Dist[n];
        for (int i = 0; i < n; i++) {
            int currDist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            distances[i] = new Dist(currDist, points[i]);
        }
        
        Arrays.sort(distances, (a, b) -> a.dist - b.dist);
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = distances[i].point;
        }
        
        return result;
    }
}