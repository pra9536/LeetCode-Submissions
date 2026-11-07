class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        int max = n - 1;

        if(n != max + 1) return false;

        int ans[] = new int[max + 1];

        for(int i = 0; i<nums.length; i++){
            if(nums[i] > max) return false;
            ans[nums[i]]++;
        }

        for(int i = 1; i<ans.length-1; i++){
           if(ans[i] != 1) return false;
        }

        if(ans[ans.length-1] != 2) return false;
        return true;
    }
}