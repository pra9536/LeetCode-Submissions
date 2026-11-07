class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;

        while(one <= two) {
            if(nums[one] == 0) {
                int temp = nums[zero];
                nums[zero] = nums[one];
                nums[one] = temp;
                one++;
                zero++;
            } else if(nums[one] == 1) {
                one++;
            } else if(nums[one] == 2) {
                int temp = nums[two];
                nums[two] = nums[one];
                nums[one] = temp;
                two--;
            }
        }
    }
}