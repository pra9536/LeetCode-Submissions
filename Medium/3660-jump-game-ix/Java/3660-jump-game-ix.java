class Solution {
    public int[] maxValue(int[] nums) {
        int minSuffix[] = new int[nums.length];

        minSuffix[nums.length-1] = nums[nums.length-1];

        int maxPrefix[] = new int[nums.length];

        maxPrefix[0] = nums[0];

        for(int i = nums.length-2; i>=0; i--){
            minSuffix[i] = Math.min(minSuffix[i+1], nums[i]);
        }

        for(int i = 1; i<nums.length; i++){
            maxPrefix[i] = Math.max(maxPrefix[i-1], nums[i]);
        }


        int ans[] = new int[nums.length];
        ans[nums.length-1] = maxPrefix[nums.length-1];
        for(int i = nums.length-2; i>=0; i--){
         ans[i] = maxPrefix[i];

         if(maxPrefix[i] > minSuffix[i+1]){
            ans[i] = ans[i+1];
         }
        }

        return ans;
    }
}