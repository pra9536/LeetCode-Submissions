class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];

        for(int k = 0; k<n; k++) {
            int i = 0;
            int j = k;

            while(j < n) {
                if(i == j || (i+1 == j && s.charAt(i) == s.charAt(j))) dp[i][j] = 1;

                else if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];

                i++;
                j++;
            }
        }

        String str = "";

        int max = Integer.MIN_VALUE;

       
       for(int i = 0; i<n; i++){
          for(int j = n-1; j>=i; j--){
            if(dp[i][j] == 1) {
                int len = j - i + 1;
                if(max < len) {
                    max = len;
                    str = s.substring(i, j+1);
                }
                break;
            }
          } 
       }

       return str;
    }
}