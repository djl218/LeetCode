// n = piles.length
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        
        int coins = 0;
        for (int i = piles.length - 2; i >= piles.length / 3; i -= 2){
            coins += piles[i];
        }
        
        return coins;
    }
}
