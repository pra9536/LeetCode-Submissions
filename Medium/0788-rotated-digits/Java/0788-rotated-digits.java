class Solution {

    public boolean check(int n){
        boolean changed = false;
        while(n > 0){
            int temp = n%10;

            if(temp == 3 || temp == 4 || temp == 7) return false;

            if(temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                changed = true;
            }
            n = n/10;
        }

        return changed; 
    }
    public int rotatedDigits(int n) {
        int count = 0;

        for(int i = 1; i<=n; i++){
            if(check(i)) count++;
        }
        return count;
    }
}