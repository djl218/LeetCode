// Rotate elements by 1 step for k cycles
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        while (k-- > 0) {
            int temp1 = nums[0];
            int temp2 = 0;
            for (int i = 1; i < nums.length; i++) {
                temp2 = nums[i];
                nums[i] = temp1;
                temp1 = temp2;
            }
            nums[0] = temp2;
        }
    }
}

// Swap elements that are k % n spots apart
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int counter = n;
        int start = 0;
        while (counter > 0) {
            int i = start;
            int temp1 = nums[start];
            do {
                int temp2 = nums[(i + k) % n];
                nums[(i + k) % n] = temp1;
                temp1 = temp2;
                counter--;
                i = (i + k) % n;
            } while (i != start);
            start++;
        }
    }
}

// Coolest way to do it :)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
