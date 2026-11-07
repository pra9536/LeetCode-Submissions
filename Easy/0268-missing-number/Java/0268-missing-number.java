class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int sum = (n * (n+1)) / 2;

        int numSum = 0;

        for(int val : nums) numSum += val;

        return sum - numSum;
    }
}