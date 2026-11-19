class Solution {
    public int helper(int i, int j, String s, int [][]dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i != j && s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + helper(i+1, j-1, s, dp);
        }
        if(i == j && s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 1 + helper(i+1, j-1, s, dp);
        }

        int first = helper(i+1, j, s, dp);
        int second = helper(i, j-1, s, dp);

        return dp[i][j] = Math.max(first, second);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return helper(0, n-1, s, dp);
    }
}