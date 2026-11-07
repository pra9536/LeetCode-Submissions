class Solution {
    
    public int countMonobit(int n) {
        int curr = 1;
        int ans = 1;
        while(ans <= n){
            curr++;
            ans = (ans << 1) | 1;
        }

        return curr;
    }
}