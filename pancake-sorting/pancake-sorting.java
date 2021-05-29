// n = arr.length
// Time: O(n^2)
// Space: O(1)
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int biggest = arr.length;
        for (int i = 0; i < n ; i++) {
            int idx = find(arr, biggest);
            pancakeFlip(arr, idx);
            result.add(idx + 1);
            pancakeFlip(arr, biggest - 1);
            result.add(biggest--);
        }
        return result;
    }
    
    private void pancakeFlip(int[] arr, int k) {
        int l = 0, r = k;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    
    private int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}