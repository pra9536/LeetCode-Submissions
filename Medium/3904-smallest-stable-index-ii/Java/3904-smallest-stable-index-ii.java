class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int []prevMax = new int[nums.length];
        int []suffixMin = new int[nums.length];

        prevMax[0] = nums[0];
        suffixMin[nums.length-1] = nums[nums.length-1];

        for(int i = 1; i<nums.length; i++) {
              prevMax[i] = Math.max(prevMax[i-1], nums[i]);
        }

        for(int i = nums.length-2; i>=0; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }


        for(int i = 0; i<nums.length; i++) {
            if(prevMax[i] - suffixMin[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}