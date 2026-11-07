class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int first = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                List<Integer> temp = new ArrayList<>();
                int second = nums[j];
                int third = nums[k];
                if((first + second + third) == 0) {
                    temp.add(first);
                    temp.add(second);
                    temp.add(third);
                    list.add(temp);
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(k > j && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } 
                else if((first + second + third) < 0) j++;
                else k--;
            }
        }
        return list;
    }
}