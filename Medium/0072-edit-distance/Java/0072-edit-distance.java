class Solution {
    public int helper(int i, int j, String word1, String word2, int [][]dp) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = helper(i+1, j+1, word1, word2, dp);
        }
        
        int insert = 1 + helper(i, j+1, word1, word2, dp);
        int delete = 1 + helper(i+1, j, word1, word2, dp);
        int replace = 1 + helper(i+1, j+1, word1, word2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int [][]dp = new int[m][n];

        for(int arr[] : dp) Arrays.fill(arr, -1);

        if(m == 0 || n == 0) return Math.max(m, n);

        return helper(0, 0, word1, word2, dp);
    }
}