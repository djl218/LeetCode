// n = nums.length
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) return true;
            if (num < first) first = num;
            if (num > first) second = num;
        }
        return false;
    }
}