class Solution {

    long[][] temp1 = new long[60][60];
    public void helper(){
        for(int i = 0; i<60; i++){
            temp1[i][0] = temp1[i][i] = 1;
            for(int j = 1; j<i; j++){
                temp1[i][j] = Math.min((long)1e18, temp1[i-1][j-1] + temp1[i-1][j]);
            }
        }
    }
    
    public long nthSmallest(long n, int k) {
        long[] temp2 = {n, k};

        helper();

        long ans = 0;
        int left = k;

        for(int i = 50; i>= 0; i--){
            if(left == 0) break;

            long count = temp1[i][left];

            if(count >= n){
                
            }else{
                ans |= (1L << i);
                n -= count;
                left--;
            }
        }
        return ans;
    }
}