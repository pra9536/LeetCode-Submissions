class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void set(int arr[], List<Integer> list, int idx){
        if(idx >= arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        set(arr, list, idx+1);
        list.remove(list.size()-1);
        set(arr, list, idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {

       set(nums, new ArrayList<>(), 0);
       return ans;
        
    }
}