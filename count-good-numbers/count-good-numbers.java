// Time: O(log n)
// Space: O(1)
class Solution {
    public int countGoodNumbers(long n) {
        long result = 0;
        long even = 0, odd = 0;
        if (n % 2 != 0) {
            even = n / 2 + 1;
            odd = n / 2;
        } else {
            even = n / 2;
            odd = n / 2;
        }
        long mod = 1_000_000_007;
        result += fastPower(5, even, mod) * fastPower(4, odd, mod);
        return (int)(result % mod);
    }
    
    private long fastPower(int x, long n, long mod) {
        long result = 1;
        long currentProduct = x;
        for (long i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                result = (result * currentProduct) % mod;
            }
            currentProduct = (currentProduct * currentProduct) % mod;
        }
        return result;
    }
}