class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean []flag = new boolean[n];
        Arrays.fill(flag, true);
        flag[0] = false;
        flag[1] = false;
        for(int i = 2; i*i<n; i++){
            if(flag[i]){
                for(int j = i*2; j<n; j += i){
                    flag[j] = false;
                }
            }
        }
        int count = 0;
        for(boolean val : flag){
            if(val) count++;
        }
        return count;
    }
}