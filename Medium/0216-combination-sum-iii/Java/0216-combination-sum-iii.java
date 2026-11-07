class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void combination(int []arr, int n, int idx, int k, List<Integer> list, int sum){
        
        if(sum == n && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(sum > n || list.size() > k || idx == arr.length) return;

        list.add(arr[idx]);

        sum += arr[idx];
        
        combination(arr, n, idx+1, k, list, sum);
         
        sum -= list.get(list.size()-1);
        list.remove(list.size()-1);

        combination(arr, n, idx+1, k, list, sum);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
       int []arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        combination(arr, n, 0, k, new ArrayList<>(), 0);
        return ans;
    }
}