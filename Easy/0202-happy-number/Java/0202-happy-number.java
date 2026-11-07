class Solution {

    public int findSquareDigit(int n) {
        int sum = 0;
        while(n > 0) {
            int rem = n % 10;
            sum += (int)Math.pow(rem, 2);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = findSquareDigit(n);
        int fast = findSquareDigit(findSquareDigit(n));

        while(fast != 1 && slow != 1) {
            if(slow == fast) return false;
            slow = findSquareDigit(slow);
            fast = findSquareDigit(findSquareDigit(fast));
        }

        return true;
    }
}