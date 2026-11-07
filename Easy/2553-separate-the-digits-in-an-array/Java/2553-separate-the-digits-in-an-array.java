class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i< nums.length; i++){
            String str = String.valueOf(nums[i]);

            for(int j = 0; j<str.length(); j++){
                char ch = str.charAt(j);
                list.add((int)(ch - '0'));
            }
        }
      
      int ans[] = new int[list.size()];

      for(int i = 0; i<ans.length; i++){
        ans[i] = list.get(i);
      }

      return ans;
        
    }
}