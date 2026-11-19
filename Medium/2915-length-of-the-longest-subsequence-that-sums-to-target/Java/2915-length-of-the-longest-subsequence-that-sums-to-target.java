class Solution {
    public int helper(List<Integer> nums, int target, int idx, int sum, int [][]dp) {
        if(idx == nums.size()) {
            if(sum == target) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];

        int max = Integer.MIN_VALUE;
            int skip = helper(nums, target, idx+1, sum, dp);
            if(sum + nums.get(idx) > target) return dp[idx][sum] = skip;
            else {
            int temp = helper(nums, target, idx+1, sum+nums.get(idx), dp);
            int take = (temp == Integer.MIN_VALUE) ? Integer.MIN_VALUE : 1 + temp;
            max = Math.max(max, Math.max(skip, take));
            }
        return dp[idx][sum] = max;
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    int n = nums.size();
    int [][]dp = new int[n][target+1];
    for(int []arr : dp) Arrays.fill(arr, -1);
    int ans = helper(nums, target, 0, 0, dp);
    return (ans != Integer.MIN_VALUE) ? ans : -1;
    }
}