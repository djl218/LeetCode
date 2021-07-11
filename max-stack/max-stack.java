// n = elements in stack
// Space: O(n)
class MaxStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }
    
    // Time: O(1)
    public void push(int x) {
        int currMax = maxStack.isEmpty() ? x : maxStack.peek();
        if (currMax >= x) {
            maxStack.push(currMax);
        } else {
            maxStack.push(x);
        }
        mainStack.push(x);
    }
    
    // Time: O(1)
    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }
    
    // Time: O(1)
    public int top() {
        return mainStack.peek();
    }
    
    // Time: O(1)
    public int peekMax() {
        return maxStack.peek();
    }
    
    // Time: O(n)
    public int popMax() {
        int currMax = peekMax();
        Stack<Integer> temp = new Stack<>();
        while (top() != currMax) {
            temp.push(pop());
        }
        pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return currMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */