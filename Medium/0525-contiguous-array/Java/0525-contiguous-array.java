class Solution {
    public int findMaxLength(int[] nums) {
        // int sum = 0;
        // int maxLen = 0;
        // for(int i = 0; i < nums.length; i++){
        //     sum = (nums[i] == 0) ? -1 : 1;
        //     for(int j = i+1; j < nums.length; j++){
        //         sum += (nums[j] == 0) ? -1 : 1;
        //         if(sum == 0){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //     }
        // }
        // return maxLen;

        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i<nums.length; i++){
              sum += nums[i];
              if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
              } else {
                 map.put(sum, i);
              }
        }
        return maxLen;
    }
}