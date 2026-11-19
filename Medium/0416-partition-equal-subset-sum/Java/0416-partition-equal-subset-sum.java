class Solution {
    public boolean helper(int i, int []nums, int target, int [][]dp) {
        if(i == nums.length) return target == 0;

        if(dp[i][target] != -1) return dp[i][target] == 1;

        boolean ans = false;

        boolean skip = helper(i+1, nums, target, dp);
        if(nums[i] > target) ans = skip;
        else {
        boolean take = helper(i+1, nums, target - nums[i], dp);
        ans = skip || take;
        }
        dp[i][target] = (ans) ? 1 : 0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
       int sum = 0;
       for(int num : nums) sum += num;
       if(sum % 2 != 0) return false;

       else {
        int target = sum / 2;

        int n = nums.length;
        int [][]dp = new int[n][target+1];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        return helper(0, nums, target, dp);
       } 
    }
}