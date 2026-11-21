class Solution {
    public int helper(int i, int prev, int nums[], int [][]dp) {
        if(i == nums.length) return 0;

        if(dp[i][prev + 1] != -1) return dp[i][prev + 1];

        int skip = helper(i+1, prev, nums, dp);
        int take = 0;

        if(prev == -1 || nums[prev] < nums[i]) {
            take = 1 + helper(i+1, i, nums, dp);
        }

        return dp[i][prev + 1] = Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int [][]dp = new int[n][n+1];

        for(int []arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        return helper(0, -1, nums, dp);
    }
}