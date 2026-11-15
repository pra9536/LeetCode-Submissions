class Solution {
    public int longestConsecutive(int[] nums) {
         
         int length = 0;

         HashSet<Integer> set = new HashSet<>();

         for(int i = 0; i<nums.length; i++) set.add(nums[i]);
         int max = 0;

         for(int num : set) {
            if(!set.contains(num - 1)) {
                length++;

                while(set.contains(num + length)) length++;
            }

            max = Math.max(max, length);
            length = 0;
         }

         return max; 
    }
}