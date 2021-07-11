// Top-Down DP with Memoization
// n = costs.length
// Time: O(n)
// Space: O(n)
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


// Bottom-Up DP with Tabulation
// n = costs.length
// Time: O(n)
// Space: O(1)
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}
