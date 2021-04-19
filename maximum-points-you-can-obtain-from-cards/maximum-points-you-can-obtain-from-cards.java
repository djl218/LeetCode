// Brute-force recursion
// TLE
// Time: O(2^k)
// Space: O(k)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k == n) return Arrays.stream(cardPoints).sum();
        return findMaxScore(cardPoints, k, 0, n - 1);
    }
    
    private int findMaxScore(int[] cardPoints, int k, int left, int right) {
        if (k <= 0) return 0;
        
        int takeFromBeginning = cardPoints[left] + findMaxScore(cardPoints, k - 1, left + 1, right);
        int takeFromEnd = cardPoints[right] + findMaxScore(cardPoints, k - 1, left, right - 1);
        
        return Math.max(takeFromBeginning, takeFromEnd);
    }
}
/*
Was having trouble doing top-down dynamic programming with memoization.
Difficult to keep track of caching for left and right sides of array.
Went to discussion board and saw tons of posts with sliding window in description.
Realized that I might have been on the wrong track. :)
Here is my original sliding window implementation.
*/
// Sliding window
// Time: O(k)
// Space: O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k == n) 
            return Arrays.stream(cardPoints).sum();
        
        int leftIdx = 0, leftSum = 0;
        while (leftIdx < k)
            leftSum += cardPoints[leftIdx++];
        
        leftIdx--;
        
        int max = leftSum;
        int rightIdx = n - 1, rightSum = 0;
        while (leftIdx > -1) {
            if (leftIdx >= 0) {
                leftSum -= cardPoints[leftIdx];
                rightSum += cardPoints[rightIdx];
                max = Math.max(max, leftSum + rightSum);
                leftIdx--;
                rightIdx--;
            } else {
                rightSum += cardPoints[rightIdx];
                max = Math.max(max, rightSum);
                leftIdx--;
            }
        }
        
        return max;
    }
}
