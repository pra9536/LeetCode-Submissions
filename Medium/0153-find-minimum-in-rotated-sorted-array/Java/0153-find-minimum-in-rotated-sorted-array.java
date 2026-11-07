class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // int ans = Integer.MAX_VALUE;

        while(left < right) {
            int mid = (left + right) / 2;

            // ans = Math.min(ans, nums[mid]);
            
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}