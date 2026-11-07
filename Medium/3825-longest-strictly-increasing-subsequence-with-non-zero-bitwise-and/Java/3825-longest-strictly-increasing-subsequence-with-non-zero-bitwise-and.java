class Solution {

    private int helper(List<Integer> list){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : list){
            int idx = Collections.binarySearch(ans, i);
            if(idx < 0) idx = -idx-1;
            if(idx == ans.size()){
                ans.add(i);
            } else {
                ans.set(idx, i);
            }
        }
        return ans.size();
    }
    public int longestSubsequence(int[] nums) {
        int count = 0;
        for(int i = 0; i<=30; i++){
            List<Integer> list = new ArrayList<>();
            for(int x : nums){
                if((x&(1<<i)) != 0){
                    list.add(x);
                }
            }
            if(!list.isEmpty()){
                count = Math.max(count, helper(list));
            }
        }
        return count;
    }
}