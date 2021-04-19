// Heap
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }
        
        int value = 0;
        while (k-- > 0) {
            int[] polled = minHeap.poll();
            value = polled[0];
            int row = polled[1];
            int col = polled[2];
            if (col + 1 >= n) continue;
            minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
        }
        
        return value;
    }
}

// Binary Search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};
            int count = countLessEqual(matrix, mid, smallLargePair);
            
            if (count == k) 
                return smallLargePair[0];
            else if (count < k)
                lo = smallLargePair[1];
            else
                hi = smallLargePair[0];
        }
        return lo;
    }
    
    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}
