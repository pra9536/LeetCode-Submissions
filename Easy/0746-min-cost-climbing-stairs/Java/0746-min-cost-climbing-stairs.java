class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = cost[0];
        int b = cost[1];
        for(int i = 2; i < n; i++) {
            // dp[i] = Math.min(cost[i] + dp[i-1], cost[i] + dp[i-2]);

            int curr = Math.min(cost[i] + b, cost[i] + a);
            a = b;
            b = curr;
        }
        return Math.min(a, b);
    }
}