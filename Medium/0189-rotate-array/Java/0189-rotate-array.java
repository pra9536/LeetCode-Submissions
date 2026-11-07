class Solution {
    // public void reverse(int nums[], int i, int j){
    //     while(j > i){
    //         int temp = nums[i];
    //         nums[i] = nums[j];
    //         nums[j] = temp;
    //         i++;
    //         j--;
    //     }
    // }
    public void rotate(int[] nums, int k) {
        int n = nums.length; 
        k = k % n;
    //    reverse(nums, 0, nums.length-1);
    //    reverse(nums, 0, k-1);
    //    reverse(nums, k, nums.length-1);

    int temp[] = new int[nums.length];
    for(int i = 0; i<n; i++){
        temp[i] = nums[(i-k+n)%n];
    }
    for(int i = 0; i<n; i++){
        nums[i] = temp[i];
    }
    }
}