class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void count(int []arr, int i, int sum, List<Integer> list){
            if(sum == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(i >= arr.length || sum < 0) return;

        if(arr[i] <= sum){
        list.add(arr[i]);
        count(arr, i, sum-arr[i], list);
        list.remove(list.size()-1);
        }
        count(arr, i+1, sum, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        count(candidates, 0, target, new ArrayList<>());
        return ans;
    }
}