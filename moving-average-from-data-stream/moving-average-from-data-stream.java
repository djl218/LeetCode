// n = size
// Time: O(1)
// Space: O(n)
class MovingAverage {
    Queue<Integer> queue;
    double sum;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        
        if (queue.size() >= size)
            sum -= queue.poll();
        
        queue.offer(val);
        
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */