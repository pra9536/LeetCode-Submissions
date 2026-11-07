class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int tens = 0;
        int twenty = 0;
        for(int i = 0; i<bills.length; i++){
           if(bills[i] == 5) five++;
           else if(bills[i] == 10) {
            if(five <= 0) return false;
            tens++;
            five--;
           } else{
            if(five <= 0) return false;
            if(tens <= 0 && five < 3) return false;
            if(tens <= 0){
                five -= 3;
            } else{
                tens--;
                five--;
            }
            twenty++;
        }
        }
        return true;
    }
}