class ProductOfNumbers {
    List<Integer> numList;
    List<Integer> preList;

    public ProductOfNumbers() {
        this.numList = new ArrayList<>();
        this.preList = new ArrayList<>();
    }
    
    // Time: O(1)
    public void add(int num) {
        if (num == 0) {
            preList = new ArrayList<>();
        }
        numList.add(num);
        if (preList.isEmpty() || preList.get(preList.size() - 1) == 0) {
            preList.add(num);
        } else {
            preList.add(num * preList.get(preList.size() - 1));
        }
    }
    
    // Time: O(1) - except if n == k
    public int getProduct(int k) {
        int n = preList.size();
        if (n < k) return 0;
        int ans = preList.get(n - 1);
        if (n == k) {
            if (preList.contains(0)) {
                return 0;
            }
            return ans;
        }
        if (preList.get(n - 1 - k) == 0) {
            if (preList.get(n - k) == 0) {
                return ans;
            } else {
                return ans;
            }
        }
        return ans / preList.get(n - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
