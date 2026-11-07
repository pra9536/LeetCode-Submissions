class Solution {
    public int reverse(int x) {
        int temp = x;
        long ans = 0;
        while(temp != 0){
            ans = ans * 10 + temp % 10;
            temp = temp / 10;
            if(ans > Math.pow(2, 31) || ans < (-1) * Math.pow(2, 31)) return 0;
        }
        return (int)ans;
    }
}