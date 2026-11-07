class Solution {

    public boolean ans(int []arr, int curr, boolean vis[]){

        if(curr < 0 || curr >= arr.length || vis[curr]) return false;

        if(arr[curr] == 0) return true;

        vis[curr] = true;

        return ans(arr, curr - arr[curr], vis) || ans(arr, curr + arr[curr], vis);
    }
    public boolean canReach(int[] arr, int start) {
        boolean []vis = new boolean[arr.length];
        return ans(arr, start, vis);
    }
}