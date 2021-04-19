
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length - 1 && nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
            if (i == 0 && nums[i] > nums[i+1]) return i;
            if (i == nums.length - 1 && nums[i] > nums[i-1]) return i;
        }
        return 0;
    }
}
/*
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
*/