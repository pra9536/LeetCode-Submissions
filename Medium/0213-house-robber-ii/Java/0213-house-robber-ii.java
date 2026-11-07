class Solution {
    public int helper(int []nums, int []dp, int i, int n) {
        if(i >= nums.length || i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + helper(nums, dp, i + 2, n);
        int skip = helper(nums, dp, i + 1, n);
        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int []dp1 = new int[n+1];
        int []dp2 = new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int case1 = helper(nums, dp1, 0, n - 2);
        int case2 = helper(nums, dp2, 1, n - 1);
        return Math.max(case1, case2);
    }
}


// class Solution {
//     public int helper(int []nums, int i, int n) {
//         if(i >= nums.length || i > n) return 0;
//         int take = nums[i] + helper(nums, i + 2, n);
//         int skip = helper(nums, i + 1, n);
//         return Math.max(take, skip);
//     }
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int case1 = helper(nums, 0, n - 2);
//         int case2 = helper(nums, 1, n - 1);
//         return Math.max(case1, case2);
//     }
// }


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         int prev2 = nums[0];
//         int prev1 = Math.max(nums[0], nums[1]);
//         for(int i = 2; i <= n-2; i++) {
//             int curr = Math.max(nums[i] + prev2, prev1);
//             prev2 = prev1;
//             prev1 = curr;
//         }
//         int prev4 = 0;
//         int prev3 = nums[1];   
//          for(int i = 2; i <= n-1; i++) {
//             int curr = Math.max(nums[i] + prev4, prev3);
//             prev4 = prev3;
//             prev3 = curr;
//         }

//         return Math.max(prev1, prev3);
//     }
// }