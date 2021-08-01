// Time: O(n)
// Space: O(1)
class Solution {
    public boolean isThree(int n) {
        Set<Integer> divisors = new HashSet<>();
        int div = 1;
        while (div <= n) {
            int num = n / div;
            int r = n % div;
            if (r == 0) {
                divisors.add(num);
            }
            if (divisors.size() > 3) {
                return false;
            }
            div++;
        }
        return divisors.size() == 3;
    }
}