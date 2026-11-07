class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void combination(int []arr, int idx, int k, List<Integer> list){
        
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(idx == arr.length) return;

        list.add(arr[idx]);

        combination(arr, idx+1, k, list);

        list.remove(list.size()-1);

        combination(arr, idx+1, k, list);

        
    }
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = i+1;
        }
        combination(arr, 0, k, new ArrayList<>());
        return ans;
    }
}