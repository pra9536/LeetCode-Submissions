class Solution {
    public int helper(int index, int []nums, int []dp)
    {
        if(index >= nums.length-1) return 0;
        if(dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=nums[index]; i++){
            int res = helper(index + i, nums, dp);
            if(res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }
        return dp[index] = min;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }
}