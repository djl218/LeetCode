// Time: O(n)
// Space: O(n)
class Solution {
    int[] orig;
    int[] mod;

    public Solution(int[] nums) {
        this.orig = nums;
        this.mod = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        mod = orig.clone();
        return mod;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < mod.length; i++)
            swap(i, rand.nextInt(mod.length - i) + i);
        
        return mod;
    }
    
    private void swap(int a, int b) {
        int temp = mod[a];
        mod[a] = mod[b];
        mod[b] = temp; 
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */