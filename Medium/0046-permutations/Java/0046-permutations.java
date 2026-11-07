class Solution {
    public void permutations(int []nums, ArrayList<Integer> list, List<List<Integer>> ans, boolean []freq){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                list.add(nums[i]);
                permutations(nums, list, ans, freq);
                list.remove(list.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }
}