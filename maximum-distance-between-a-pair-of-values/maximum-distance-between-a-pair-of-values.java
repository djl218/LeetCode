// Question 2
// Binary Search

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int max = 0;
        for (int i = 0; i < n1; i++) {
            int left = i;
            int right = n2 - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[i] <= nums2[mid]) {
                    max = Math.max(max, mid - i);
                }
                if (nums1[i] <= nums2[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return max;
    }
}
/*
// Brute Force
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]) {
                    max = Math.max(max, j - i);
                } else {
                    break;
                }
            }
        }
        
        return max;
    }
}*/