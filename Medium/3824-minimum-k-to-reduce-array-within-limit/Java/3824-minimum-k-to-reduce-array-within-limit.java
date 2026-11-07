class Solution {

    public int minimumK(int[] nums) {
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int m = Math.max(max, (int)Math.sqrt(nums.length)+2);
       for(int i = 1; i<=m; i++){
           long count = 0;
           for(int j : nums){
               count += (j+i-1)/i;
               if(count > 1L*i*i) break;
           }
           if(count <= 1L*i*i) return i;
       }
        return m;
    }
}