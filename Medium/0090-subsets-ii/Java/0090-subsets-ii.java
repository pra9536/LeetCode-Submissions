class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public void set(int []nums, int idx, List<Integer> list){
       ans.add(new ArrayList<>(list));
       
       for(int i = idx; i<nums.length; i++){
        if(i > idx && nums[i] == nums[i-1]) continue;
        list.add(nums[i]);
        set(nums, i+1, list);
        list.remove(list.size()-1);
       }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        set(nums, 0, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}