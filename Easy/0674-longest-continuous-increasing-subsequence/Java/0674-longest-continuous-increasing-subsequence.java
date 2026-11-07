class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1; 
        int curr = 1;

        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i] < nums[i+1]) curr++;
            else curr = 1;

            max = Math.max(max, curr);
        }

        return max;
    }
}