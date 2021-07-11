// n = costs.length
// Time: O(3n) = O(n)
// Space: O(1)
class Solution {
    private int[][] costs;
    private int[][] memo;
    
    public int minCost(int[][] costs) {
        this.costs = costs;
        this.memo = new int[costs.length][3];
        return Math.min(Math.min(getCost(0, 0), getCost(0, 1)), getCost(0, 2));
    }
    
    private int getCost(int house, int color) {
        if (memo[house][color] != 0) {
            return memo[house][color];
        }
        int totalCost = costs[house][color];
        if (house != costs.length - 1) {
            if (color == 0) {
                totalCost += Math.min(getCost(house + 1, 1), getCost(house + 1, 2));
            } else if (color == 1) {
                totalCost += Math.min(getCost(house + 1, 0), getCost(house + 1, 2));
            } else if (color == 2) {
                totalCost += Math.min(getCost(house + 1, 0), getCost(house + 1, 1));
            }
        }
        memo[house][color] = totalCost;
        return memo[house][color];
    }
}