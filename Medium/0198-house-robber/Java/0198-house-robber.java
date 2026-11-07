class Solution {
    public int helper(int []nums, int []dp, int i) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + helper(nums, dp, i + 2);
        int skip = helper(nums, dp, i + 1);
        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        int start0 = helper(nums, dp, 0);
        int start1 = helper(nums, dp, 1);
        return Math.max(start0, start1);
    }
}


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int []dp = new int[n];
//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);
//         for(int i = 2; i<=n-1; i++) {
//          dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
//         }
//         return dp[n-1];
//     }
// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int prev2 = nums[0];
//         int prev1 = Math.max(nums[0], nums[1]);
//         for(int i = 2; i <= n-1; i++) {
//         int curr = Math.max(prev1, nums[i] + prev2);
//         prev2 = prev1;
//         prev1 = curr;
//         }
//         return prev1;
//     }
// }