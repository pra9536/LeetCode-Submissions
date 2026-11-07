class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int first = nums[i];

            for(int j = i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int second = nums[j];

                int k = j + 1;
                int l = nums.length - 1;
                
                while(k < l) {
                    int third = nums[k];
                    int fourth = nums[l];

                    long total = (long)first + (long)second + (long)third + (long)fourth;
                    
                    if(total == target) {
                        list.add(Arrays.asList(first, second, third, fourth));

                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(k < l && nums[l] == nums[l-1]) l--;

                        k++;
                        l--;
                    }
                    else if(total < target) k++;
                    else l--;
                }
            }
        }
        return list;
    }
}