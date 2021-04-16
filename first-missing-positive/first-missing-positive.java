/*
Brute Force
  Use a set - add every number in nums to set
  The missing number will be from 1 to nums.length + 1
  Iterate from 1 to n + 1 and compare to set values
  If a number from 1 to n + 1 is not in set than it is the 
  smallest missing positive integer
  
  
Optimal
  We are basically making our own HashSet
  We need to focus on any numbers that are greater than n + 1 or negative
  
  Step 1
  We need to swap these numbers to 1
  However be sure to check if 1 is in nums before swap,
  if it isn't then the smallest missing positive integer is 1
  
  Step 2
  These numbers are now "indexes" to our array
  However, these "indexes" are currently 0-based, they need to be 1-based
  Subtract 1 from each of these "indexes"
  To signify that we have seen a number, flip the sign of the number
  that corresponds each of our "indexes" only if that number is greater than 0
  
  Step 3
  If a number in array is still greater than 0 than 
  we have found the smallest missing positive integer
*/

// Brute Force
/*
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) 
            set.add(num);
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i))
                return i;
        }
        return -1;
    }
}
*/

// Optimal
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;
        boolean containsOne = false;
        
        // Step 1
        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == 1)
                containsOne = true;
            else if (nums[i] > n || nums[i] <= 0)
                nums[i] = 1;
        }
        
        if (!containsOne) return 1;
        
        // Step 2
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -1 * nums[index];
        }
        
        // Step 3
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        
        return n + 1;
    }
}
