class Solution {
    public int helper(int i, int j, String word1, String word2, int[][] dp) {
        if(i == word1.length() || j == word2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + helper(i+1, j+1, word1, word2, dp);
        }

        int first = helper(i+1, j, word1, word2, dp);
        int second = helper(i, j+1, word1, word2, dp);

        return dp[i][j] = Math.max(first, second);
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int [][]dp = new int[n][m];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        int res = helper(0, 0, word1, word2, dp);

        return m + n - 2 * res;
    }
}