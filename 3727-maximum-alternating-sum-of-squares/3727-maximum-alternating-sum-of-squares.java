class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] < 0) 
            {
                nums[i] = Math.abs(nums[i]);
            }
        }

        Arrays.sort(nums);

        long sum = 0;

        int n = nums.length;

        for(int i = n-1; i >= n/2; i--) {
            sum += nums[i] * nums[i];
        }

        for(int i = 0; i < n/2; i++) {
            sum -= nums[i] * nums[i];
        }

        return sum;
    }
}