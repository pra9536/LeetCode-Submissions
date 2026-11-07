// class Solution {
//     public int tribonacci(int n) {
//         if(n == 0 || n == 1) return n;
//         if(n == 2) return 1;
//         int a = 0;
//         int b = 1;
//         int c=  1;

//         for(int i = 3; i<=n; i++) {
//             int curr = a + b + c;
//             a = b;
//             b = c;
//             c = curr;
//         }
//         return c;
//     }
// }


// class Solution {
//     public int helper(int n) {
//         if(n == 0 || n == 1) return n;
//         if(n == 2) return 1;
//         return helper(n - 1) + helper(n - 2) + helper(n - 3);
//     }
//     public int tribonacci(int n) {
//        return helper(n);
//     }
// }

class Solution {
    public int tribonacci(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
       return dp[n];
    }
}