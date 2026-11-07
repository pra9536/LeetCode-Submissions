class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        double max = Double.MIN_VALUE;

        for(int i = 0; i<k; i++) {
            sum += nums[i];
        }

        max = sum;;

        int j = 0;

        for(int i = k; i<nums.length; i++) {
            sum += nums[i];
            sum -= nums[j];
            j++;
            max = Math.max(max, sum);
        }
        return max / k;
    }
}