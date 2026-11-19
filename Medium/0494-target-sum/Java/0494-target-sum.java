class Solution {
    public int helper(int i, int []nums, int target) {
        if(i == nums.length) {
            if(target == 0) return 1;
            else return 0;
        }

        int add = helper(i+1, nums, target - nums[i]);
        int sub = helper(i+1, nums, target + nums[i]);

        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0, nums, target);
    }
}