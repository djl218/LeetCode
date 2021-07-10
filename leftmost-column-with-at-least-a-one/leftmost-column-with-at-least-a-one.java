/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

// Time: O(m + n)
// Space: O(1)
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);
        
        int row = 0, col = n - 1; 
        while (row < m && col >= 0) {
            if (binaryMatrix.get(row, col) == 0) {
                row++;
            } else {
                col--;
            }
        }
        
        return col == n - 1 ? -1 : col + 1;
    }
}