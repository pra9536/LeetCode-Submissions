class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long max = Integer.MIN_VALUE;

        int left = 0;
        long sum = 0;
        for(int right = 0; right<nums.length; right++) {
                while(set.contains(nums[right])) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }

            set.add(nums[right]);
            sum += nums[right];

            if(set.size() > k) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++; 
            }


            if(set.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}