class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preMul = new int[n];
        int[] postMul = new int[n];

        preMul[0] = nums[0];
        postMul[n-1] = nums[n-1];

        for(int i = 1; i<n; i++){
            preMul[i] = preMul[i-1] * nums[i];
        }
        for(int i = n-2; i>=0; i--){
            postMul[i] = postMul[i+1] * nums[i];
        }

        int ans[] = new int[n];

        ans[0] = postMul[1];
        ans[n-1] = preMul[n-2];

        for(int i = 1; i<n-1; i++){
            ans[i] = preMul[i-1] * postMul[i+1];
        }
        return ans;
    }
}