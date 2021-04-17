// n = nums.length
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return nums;
        
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int maxIdx = 0;
        
        for (int i = 0; i < k; i++) {
            cleanDeque(nums, deq, k, i);
            deq.addLast(i);
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        result[0] = nums[maxIdx];
        
        for (int i = k; i < n; i++) {
            cleanDeque(nums, deq, k, i);
            deq.addLast(i);
            result[i - k + 1] = nums[deq.getFirst()];
        }
        
        return result;
    }
    
    private void cleanDeque(int[] nums, ArrayDeque<Integer> deq, int k, int i) {
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();
        
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }
}