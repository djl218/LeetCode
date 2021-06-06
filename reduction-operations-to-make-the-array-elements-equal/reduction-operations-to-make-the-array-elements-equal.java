class Solution {
    public int reductionOperations(int[] nums) {
        /*
        if (nums.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> store = new LinkedList<>();
        for (int num : nums) pq.offer(num);
        
        int count = 0;
        while (!pq.isEmpty()) {
            int polled = pq.poll();
            while(pq.peek() == polled) {
                store.offer(pq.poll());
                if (pq.isEmpty()) return count;
            }
            polled = pq.peek();
            pq.offer(polled);
            while (!store.isEmpty()) {
                pq.offer(store.poll());
            }
            count++;
        }
        return -1;
        */
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) {
                count += n - i;
            }
        }
        return count;
    }
}