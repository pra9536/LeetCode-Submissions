class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int zero = 0;
        int left = 0;
        for(int i = 0; i<nums.length; i++){
          if(nums[i] == 0) zero++;
        //   while(zero > k) {
        //     if(nums[left] == 0) zero--;
        //     left++;
        //   }
        //   if(zero <= k) maxLen = Math.max(maxLen, i-left+1);

        if(zero > k){
            if(nums[left] == 0) zero--;
            left++;
        }
        if(zero <= k) maxLen = Math.max(maxLen, i-left+1);
           
        }
        return maxLen;

    }
}