/*
// Both solutions have same time and space complexity
// n = nums.length
// Time: O(log n)
// Space: O(1)
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && nums[mid] > target)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (nums[hi] >= target && nums[mid] < target)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        
        int pivotIdx = findPivotIdx(nums);
        
        int idx1 = binarySearch(nums, target, 0, pivotIdx);
        int idx2 = binarySearch(nums, target, pivotIdx + 1, nums.length - 1);
        
        if (idx1 >= 0 && idx1 <= pivotIdx && nums[idx1] == target) return idx1;
        if (idx2 > pivotIdx && idx2 < nums.length && nums[idx2] == target) return idx2;
        return -1;
    }
    
    private int findPivotIdx(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] < nums[hi]) return 0;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return mid;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    
    private int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}