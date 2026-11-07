class Solution {

    public int solve(int coins[], int index, int amount, int[][]dp) {
        if(amount == 0) return 1;
        if(index == coins.length || amount < 0) return 0;

        if(dp[index][amount] != -1) return dp[index][amount];

        int take = solve(coins, index, amount - coins[index], dp);
        int skip = solve(coins, index + 1, amount, dp);

        return dp[index][amount] = take + skip;
    }
    public int change(int amount, int[] coins) {
        int [][]dp = new int[coins.length][amount + 1];

        for(int []row : dp) {
            Arrays.fill(row, -1);
        } 

        return solve(coins, 0, amount, dp);
    }
}