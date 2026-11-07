class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);

       long sum = 0;

        int i = nums.length-1;

       while(k > 0) {
           long ce = nums[i--];

           if(mul > 1) sum += ce * mul;
           else sum += ce;

           mul--;
           k--;
       }

        
        

       return sum;

        
    }
}