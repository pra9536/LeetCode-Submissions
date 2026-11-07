class Solution {
    public int solve(int []coins, int index, int amount, int[][]dp) {
        if(amount == 0) return 0;
        if(index == coins.length || amount < 0) return Integer.MAX_VALUE;

        if(dp[index][amount] != -1) return dp[index][amount];

        int take = solve(coins, index, amount - coins[index], dp);

        if(take != Integer.MAX_VALUE) {
            take += 1;
        }
        
        int skip = solve(coins, index + 1, amount, dp);

        return dp[index][amount] = Math.min(take, skip);
    }
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length][amount + 1];
        for(int []row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, 0, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}