class Solution {

    int dp[];
    public int ways(int nums[], int start, int target){
        if(start == nums.length - 1){
            return 0;
        }

        if(dp[start] != -2) return dp[start];

       int max = -1;

        for(int destination = start + 1; destination < nums.length; destination++){
            if(nums[destination] - nums[start] >= -target && nums[destination] - nums[start] <= target){
                int ans = ways(nums, destination, target);


                if(ans != -1)
                max = Math.max(max, ans + 1);
            }
        }

        dp[start] = max;
        
        return max;
    }
    public int maximumJumps(int[] nums, int target) {

        dp = new int[nums.length];

        Arrays.fill(dp, -2);

        return ways(nums, 0, target);
    }
}